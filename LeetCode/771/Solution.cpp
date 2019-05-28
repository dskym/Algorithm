class Solution {
public:
    int numJewelsInStones(string J, string S) {
        int count = 0;
        
        int arr[128];
        
        for(int i=0;i<128;++i)
            arr[i] = 0;
        
        for(int i=0;i<S.length();++i)
            arr[S[i]]++;
        
        for(int i=0;i<J.length();++i)
            count += arr[J[i]];
        
        return count;
    }
};
