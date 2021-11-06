class Solution {
public:
    int numSplits(string s) {
        int ret = 0;
        
        vector<int> left(26, 0);
        vector<int> right(26, 0);
        
        for(char c : s)
            right[c-'a']++;

        for(char c : s) {
            left[c-'a']++;
            right[c-'a']--;
            
            int leftCount = 0, rightCount = 0;
            
            for(int i=0;i<26;++i) {
                if(left[i] > 0)
                    leftCount++;
                if(right[i] > 0)
                    rightCount++;
            }
            
            if(leftCount == rightCount)
                ret++;
        }
        
        return ret;
    }
};
