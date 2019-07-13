class Solution {
public:
    string customSortString(string S, string T) {
        string result = "";
        
        int count[26];
        
        for(int i=0;i<26;++i)
            count[i] = 0;
        
        for(int i=0;i<T.size();++i)
            count[T[i]-'a']++;
        
        for(int i=0;i<S.size();++i) {
            for(int j=0;j<count[S[i]-'a'];++j)
                result += S[i];
            count[S[i]-'a'] = 0;
        }

        for(int i=0;i<26;++i)
            for(int j=0;j<count[i];++j)
                result += 'a' + i;
        
        return result;
    }
};
