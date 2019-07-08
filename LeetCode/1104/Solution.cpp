class Solution {
public:
    vector<int> pathInZigZagTree(int label) {
        int base[25];
        
        base[0] = 1;
        
        for(int i=1;i<23;++i)
            base[i] = base[i-1] * 2;
        
        int floor = 1;
                
        for(int i=22;i>=0;--i) {
            if(label >= base[i]) {
                floor = i;
                break;
            }
        }
        
        int index;
        
        if(floor % 2 == 1)
            index = base[floor+1] - label - 1;
        else
            index = label - base[floor];
    
        vector<int> result;
        
        result.push_back(label);

        for(int i=floor-1;i>=0;--i) {
            index /= 2;
            
            cout << index << endl;
            
            if(i % 2 == 1)
                result.push_back(base[i+1] - index - 1);    
            else
                result.push_back(index + base[i]);    
        }
        
        reverse(result.begin(), result.end());
        
        return result;
    }
};

