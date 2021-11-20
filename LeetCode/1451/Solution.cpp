class Solution {
public:
    bool static comp(string i,string j) { return (i.size()<j.size()); }
    string arrangeWords(string text) {
        vector<string> temp;
        string t = "";
        for(int i=0;i<text.size();++i) {
            if(text[i] != ' ') {
                t += tolower(text[i]);
            } else {
                temp.push_back(t);
                t = "";
            }
        }
        temp.push_back(t);
        stable_sort(temp.begin(), temp.end(), comp);
        string result = "";
        for(int i=0;i<temp.size();++i) {
            result += temp[i];
            if(i != temp.size() - 1)
                result += " ";
        }   
        result[0] = toupper(result[0]);
        return result;
    }
};
