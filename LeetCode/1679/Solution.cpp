class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        map<int, int> m;
        
        for(int num : nums) {
            if(m.find(num) == m.end()) {
                m[num] = 1;
            } else {
                m[num]++;
            }
        }
        
        int result = 0;
        for(map<int, int>::iterator it = m.begin();it != m.end();++it) {
            result += min(m[it->first], m[k-it->first]);
        }
        return result/2;
    }
};
