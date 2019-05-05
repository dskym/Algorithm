class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        map<char, int> m;
        
        m['q'] = 0;
        m['w'] = 0;
        m['e'] = 0;
        m['r'] = 0;
        m['t'] = 0;
        m['y'] = 0;
        m['u'] = 0;
        m['i'] = 0;
        m['o'] = 0;
        m['p'] = 0;

        m['a'] = 1;
        m['s'] = 1;
        m['d'] = 1;
        m['f'] = 1;
        m['g'] = 1;
        m['h'] = 1;
        m['j'] = 1;
        m['k'] = 1;
        m['l'] = 1;

        m['z'] = 2;
        m['x'] = 2;
        m['c'] = 2;
        m['v'] = 2;
        m['b'] = 2;
        m['n'] = 2;
        m['m'] = 2;
        
        int n = words.size();
        vector<string> result;
        
        for(int i=0;i<n;++i) {
            bool flag = true;

            char t = words[i][0];
            
            if(t >= 'A' && t <= 'Z')
                t = t - 'A' + 'a';
            
            int temp = m[t];
            
            for(int j=1;j<words[i].size();++j) {
                char t2 = words[i][j];

                if(t2 >= 'A' && t2 <= 'Z')
                    t2 = t2 - 'A' + 'a';

                int temp2 = m[t2];
                
                if(temp != temp2) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                result.push_back(words[i]);
            }
        }
        
        return result;
    }
};
