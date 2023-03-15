class Solution {
public:
    long long makeSimilar(vector<int>& nums, vector<int>& target) {
        vector<int> odd1, odd2;
        vector<int> even1, even2;

        for(int i=0;i<nums.size();++i) {
            if(nums[i] % 2 == 0) {
                even1.push_back(nums[i]);
            } else {
                odd1.push_back(nums[i]);
            }

            if(target[i] % 2 == 0) {
                even2.push_back(target[i]);
            } else {
                odd2.push_back(target[i]);
            }
        }

        sort(odd1.begin(), odd1.end());
        sort(odd2.begin(), odd2.end());
        sort(even1.begin(), even1.end());
        sort(even2.begin(), even2.end());
 
        vector<int> diff1, diff2;
        for(int i=0;i<odd1.size();++i) {
            diff1.push_back(odd1[i]-odd2[i]);
        }
        for(int i=0;i<even1.size();++i) {
            diff2.push_back(even1[i]-even2[i]);
        }

        long long count = 0;
        for(int i=0;i<diff1.size();++i) {
            if(diff1[i] > 0) {
                count += diff1[i]/2;
            }
        }
        for(int i=0;i<diff2.size();++i) {
            if(diff2[i] > 0) {
                count += diff2[i]/2;
            }
        }
        return count;
    }
};
