class Solution {
public:
    int dayOfYear(string date) {
        int dates[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int year = 1000 * (date[0] - '0') + 100 * (date[1] - '0') + 10 * (date[2] - '0') +  (date[3] - '0');
        int month = 10 * (date[5] - '0') + (date[6] - '0');
        int day = 10 * (date[8] - '0') + (date[9] - '0');
        
        for(int i=0;i<month-1;++i)
            day += dates[i];
        
        if(year % 4 == 0 && year % 100 == 0 && year % 400 == 0 && month > 2)
            return day + 1;
        else if(year % 4 == 0 && year % 100 == 0)
            return day;
        else if(year % 4 == 0 && month > 2)       
            return day + 1;
        else
            return day;
    }
};
