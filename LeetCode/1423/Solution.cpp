class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int left = cardPoints.size()-k, right = cardPoints.size()-1;
        int result = 0;
        for(int i=0;i<k;++i) {
            result+=cardPoints[left+i];
        }
        int temp = result;
        for(int i=0;i<k;++i) {
            temp-=cardPoints[left+i];
            temp+=cardPoints[(i+right+1)%cardPoints.size()];
            result = max(result, temp);
        }
        return result;
    }
};
