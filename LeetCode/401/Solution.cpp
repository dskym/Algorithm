class Solution {
public:
    vector<string> result;
    
    string makeTime(int* binary) {
        int hour = 0;
        int minute = 0;
        
        int base = 1;
        
        for(int i=0;i<6;++i) {
            if(binary[i] == 1)
                minute += base;
                
            base *= 2;
        }
        
        base = 1;
        
        for(int i=6;i<10;++i) {
            if(binary[i] == 1)
                hour += base;
                
            base *= 2;
        }
        
        if(hour >= 12 || minute >= 60)
            return "";
        
        char time[6];
        
        sprintf(time, "%d:%02d", hour, minute);
        
        string ret = string(time);
        
        return ret;
    }
    
    void makeBinary(int index, int count, int* binary) {
        if(count == 0) {
            string time = makeTime(binary);
            
            if(time != "")
                result.push_back(time);
        }
        
        for(int i=index+1;i<10;++i) {
            binary[i] = 1;
            makeBinary(i, count-1, binary);
            binary[i] = 0;
        }
    }
    
    vector<string> readBinaryWatch(int num) {
        if(num == 0)
            return {"0:00"};
        
        int binary[10] = {0, };
        
        for(int i=0;i<10;++i) {
            binary[i] = 1;
            makeBinary(i, num-1, binary);
            binary[i] = 0;
        }
        
        return result;
    }
};

