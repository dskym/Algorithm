class Solution {
public:
    int maximumScore(int a, int b, int c) {
        vector<int> temp;
        temp.push_back(a);
        temp.push_back(b);
        temp.push_back(c);
        sort(temp.begin(), temp.end());
        
        return (temp[0] + temp[1]) - ((temp[0] + temp[1]-temp[2] > 0) ? ((temp[0] + temp[1]-temp[2])+1)/2 : 0);
    }
};
