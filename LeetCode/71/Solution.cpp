class Solution {
public:
    vector<string> split(string input, char delimiter) {
        vector<string> result;
        stringstream ss(input);
        string tmp;

        while (getline(ss, tmp, delimiter)) result.push_back(tmp);

        return result;
    }
    string simplifyPath(string path) {
        vector<string> s = split(path, '/');
        vector<string> ret;
        
        for(string temp : s) {
            if(temp == "" || temp == ".") {
                continue;
            } else if(temp == "..") {
                if(ret.size() != 0)
                    ret.pop_back();
            } else {
                ret.push_back(temp);
            }
        }        
        
        string r;
        
        for(string t : ret) {
            r += "/" + t;
        }
        
        return r == "" ? "/" : r;
    }
};
