class Solution {
public:
    int calculateIntersection(vector<int> a, vector<int> b) {
        if(a[1] <= b[0] || b[1] <= a[0])
            return 0;
        
        if(a[0] > b[0])
            return min(b[1], a[1]) - a[0];
        else
            return min(b[1], a[1]) - b[0];
        
        return 0;
    }
    vector<int> minAvailableDuration(vector<vector<int>>& slots1, vector<vector<int>>& slots2, int duration) {
        int index1 = 0, index2 = 0;
        sort(slots1.begin(), slots1.end());
        sort(slots2.begin(), slots2.end());
        while(index1 < slots1.size() && index2 < slots2.size()) {
            int val = calculateIntersection(slots1[index1], slots2[index2]);
            
            if(val >= duration) {
                return {max(slots1[index1][0], slots2[index2][0]), max(slots1[index1][0], slots2[index2][0])+duration};
            }
            
            if(slots1[index1][1] > slots2[index2][1]) {
                index2++;
            } else if(slots1[index1][1] < slots2[index2][1]) {
                index1++;
            } else {
                index1++;
                index2++;
            }
        }
        
        return {};
    }
};
