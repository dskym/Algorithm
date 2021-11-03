class Solution {
public:
    int reverse(int x) {
        bool minus = x > 0 ? false : true;

        int temp = 1;
        for(int i=0;i<30;++i) {
            temp *= 2;
        }
        int temp2 = temp - 1 + temp;
        int temp3 = -2 * temp;

        string max = "";
        string min = "";
        string value = "";
        for(int i=0;i<10;++i) {
            max = to_string(temp2 % 10) + max;
            temp2 /= 10;
        }
        for(int i=0;i<10;++i) {
            min = to_string(temp3 % 10).substr(1) + min;
            temp3 /= 10;
        }
        for(int i=0;i<10;++i) {
            if(x == 0)
                value = "0" + value;
            else {
                if(x % 10 >= 0)
                    value = value + to_string(x % 10);
                else
                    value = value + to_string(x % 10).substr(1);
                x /= 10;
            }
        }
        
        if(minus == false) {
            for(int i=0;i<10;++i) {
                if(value[i] > max[i])
                    return 0;
                else if(value[i] == max[i])
                    continue;
                else {
                    int ret = 0;
                    int base = 1000000000;
                    for(int i=0;i<10;++i) {
                        ret += base * (value[i] - '0');
                        base /= 10;
                    }
                    return ret;
                }
            }
        } else {
            for(int i=0;i<10;++i) {
                if(value[i] > min[i])
                    return 0;
                else if(value[i] == min[i])
                    continue;
                else {
                    int ret = 0;
                    int base = 1000000000;
                    for(int i=0;i<10;++i) {
                        ret += base * (value[i] - '0');
                        base /= 10;
                    }
                    return ret * -1;
                }
            }
        }
        return 0;
    }
};
