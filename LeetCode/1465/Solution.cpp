class Solution {
public:
    int maxArea(int h, int w, vector<int>& horizontalCuts, vector<int>& verticalCuts) {
        horizontalCuts.push_back(0);
        horizontalCuts.push_back(h);
        sort(horizontalCuts.begin(), horizontalCuts.end());
        
        verticalCuts.push_back(0);
        verticalCuts.push_back(w);
        sort(verticalCuts.begin(), verticalCuts.end());
        
        vector<int> a;
        vector<int> b;
        
        for(int i=1;i<horizontalCuts.size();++i) {
                a.push_back(horizontalCuts[i]-horizontalCuts[i-1]);
        }
        for(int i=1;i<verticalCuts.size();++i) {
                b.push_back(verticalCuts[i]-verticalCuts[i-1]);
        }

        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
        
        return (unsigned long long)a[a.size()-1] * (unsigned long long)b[b.size()-1] % 1000000007;
    }
};
