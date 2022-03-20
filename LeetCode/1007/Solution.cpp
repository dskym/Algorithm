class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        int ret = 100000;
        
        int base = tops[0];
        int cnt = 0;
        for(int j=1;j<tops.size();++j) {
            if(tops[j] == base) {
                continue;
            } else if(bottoms[j] == base) {
                cnt++;
            } else {
                cnt = 100000;
                break;
            }
        }
        ret = min(ret, cnt);
            
        cnt = 1;
        for(int j=1;j<tops.size();++j) {
            if(bottoms[j] == base) {
                continue;
            } else if(tops[j] == base) {
                cnt++;
            } else {
                cnt = 100000;
                break;
            }
        }
        ret = min(ret, cnt);
        
        base = bottoms[0];
        cnt = 0;
        for(int j=1;j<tops.size();++j) {
            if(bottoms[j] == base) {
                continue;
            } else if(tops[j] == base) {
                cnt++;
            } else {
                cnt = 100000;
                break;
            }
        }
        ret = min(ret, cnt);
            
        cnt = 1;
        for(int j=1;j<tops.size();++j) {
            if(tops[j] == base) {
                continue;
            } else if(bottoms[j] == base) {
                cnt++;
            } else {
                cnt = 100000;
                break;
            }
        }
        ret = min(ret, cnt);

        return ret == 100000 ? -1 : ret;
    }
};
