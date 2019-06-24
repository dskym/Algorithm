class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        set<int> s;
        int len = s.size();
        
        for(int num : nums) {
            s.insert(num);
            
            if(len == s.size())
                return true;
            
            len = s.size();
        }
        
        return false;
    }
};
