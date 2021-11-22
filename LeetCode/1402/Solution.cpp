class Solution {
public:
    int maxSatisfaction(vector<int>& satisfaction) {
        int ret = 0;
        
        sort(satisfaction.begin(),satisfaction.end());
        
        for(int i=0;i<satisfaction.size();++i) {
            int result = 0;
                    
            int counter = 1;
            for(int j=i;j<satisfaction.size();++j) {
                result += satisfaction[j] * counter;
                counter++;
            }
            if(ret < result)
                ret = result;
        }
        return ret;
    }
};
