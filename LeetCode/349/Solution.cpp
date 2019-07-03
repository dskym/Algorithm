class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        set<int> s;
        
        for(int num1 : nums1) {
            for(int num2 : nums2) {
                if(num1 == num2)
                    s.insert(num1);
            }
        }
        
        vector<int> result;
        
        set<int>::iterator it;
        
        for(it = s.begin();it != s.end();++it)
            result.push_back(*it);
        
        return result;
    }
};
