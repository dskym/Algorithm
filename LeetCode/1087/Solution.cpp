#include <algorithm>

class Solution {
public:
    vector<string> expand(string s) {
        vector<string> result;
        for(int i=0;i<s.size();++i) {
            if(s[i] == '{') {
                vector<string> copyString;
                while(s[++i] != '}') {
                    if(s[i] >= 'a' && s[i] <= 'z') {
                        if(result.size() == 0) {
                            string temp;
                            temp += s[i];
                            copyString.push_back(temp);
                        } else {
                            for(int j=0;j<result.size();++j) {
                                copyString.push_back(result[j] + s[i]);
                            }
                        }
                    }
                }
                result = copyString;
            } else if(s[i] >= 'a' && s[i] <= 'z'){
                vector<string> copyString;
                if(result.size() == 0) {
                    string temp;
                    temp += s[i];
                    copyString.push_back(temp);
                } else {
                    for(int j=0;j<result.size();++j) {
                        copyString.push_back(result[j] + s[i]);
                    }
                }
                result = copyString;
            }
        }
        sort(result.begin(), result.end());
        return result;
    }
};
