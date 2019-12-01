class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        int c_magazine[26] = {0, };
        int c_ransomNote[26] = {0, };
        
        for(char c : magazine)
            c_magazine[c-'a']++;

        for(char c : ransomNote)
            c_ransomNote[c-'a']++;

        for(int i=0;i<26;++i)
            if(c_ransomNote[i] > c_magazine[i])
                return false;
        
        return true;
    }
};
