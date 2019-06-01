class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        string s[26] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        set<string> r;
        
        for(int i=0;i<words.size();++i) {
            string temp = "";
            
            for(int j=0;j<words[i].size();++j) {
                temp += s[words[i][j] - 'a'];
            }
            
            r.insert(temp);
        }
        
        return r.size();
    }
};
