class Solution {
public:
    vector<int> deckRevealedIncreasing(vector<int>& deck) {
        bool flag = true;
        int count = 0;
        int deck_index = 0;
        int idx = 0;
        
        sort(deck.begin(), deck.end());
        
        vector<int> v(deck.size());
        
        while(count != deck.size()) {
            if(flag && v[idx] == 0) {
                v[idx++] = deck[deck_index++];
                flag = false;
                count++;
            } else {
                if(v[idx] == 0)
                    flag = true;
                idx++;
            }
            
            if(idx == deck.size())
                idx = 0;
        }
        
        return v;
    }
};
