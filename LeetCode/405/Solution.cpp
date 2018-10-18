class Solution {
public:
    string toHex(int num) {
        if(num == 0)
            return "0";
        
        string result = "";
        
        long long t;
        
        if(num < 0)
            t = num + 4294967296;
        else
            t = num;
        
        while(t != 0) {
            int temp = t % 16;
            t /= 16;

            if(temp == 10)
                result = 'a' + result;
            else if(temp == 11)
                result = 'b' + result;
            else if(temp == 12)
                result = 'c' + result;
            else if(temp == 13)
                result = 'd' + result;
            else if(temp == 14)
                result = 'e' + result;
            else if(temp == 15)
                result = 'f' + result;
            else
                result = char(temp + 48) + result;
        }
                
        return result;
    }
};
