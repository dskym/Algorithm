class Solution {
public:
    string reverseOnlyLetters(string S) {
        int start = 0;
        int end = S.size() - 1;
        
        while(start < end) {
            if(('a' <= S[start] && S[start] <= 'z') || ('A' <= S[start] && S[start] <= 'Z')) {} else {
                start++;
                
                continue;
            }

            if(('a' <= S[end] && S[end] <= 'z') || ('A' <= S[end] && S[end] <= 'Z')) {} else {
                end--;
                
                continue;
            }
            
            char temp = S[start];
            S[start] = S[end];
            S[end] = temp;
            
            start++;
            end--;
        }
        
        return S;
    }
};
