class Solution {
public:
    int maxNumberOfBalloons(string text) {
        int count[26] = {0, };
        
        for(int i=0;i<text.size();++i)
            count[text[i]-'a']++;
        
        int ret = 10000;
        
        ret = min(ret, count['a'-'a'] / 1);
        ret = min(ret, count['b'-'a'] / 1);
        ret = min(ret, count['l'-'a'] / 2);
        ret = min(ret, count['o'-'a'] / 2);
        ret = min(ret, count['n'-'a'] / 1);
        
        return ret;
    }
};
