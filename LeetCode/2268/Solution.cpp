class Solution {
public:
    int minimumKeypresses(string s) {
        vector<int> count(26, 0);
        for(char c : s) {
            count[c-'a']++;
        }
        sort(count.begin(), count.end());
        reverse(count.begin(), count.end());
        int base = 0;
        int result = 0;
        for(int i=0;i<count.size();++i) {
            if(i % 9 == 0)
                base++;
            result += base * count[i];
        }
        return result;
    }
};
