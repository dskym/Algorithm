class Solution {
public:
    string convertToBase7(int num) {
        string result = "";
        bool flag = false;
        
        if(num == 0)
            return "0";        
        else if(num < 0) {
            num *= -1;
            flag = true;
        }
        
        while(num != 0) {
            int temp = num % 7;
            
            result = to_string(temp) + result;
            
            num /= 7;
        }
        
        if(flag == true)
            result = "-" + result;
        
        return result;
    }
};
