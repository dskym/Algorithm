class Solution {
public:
    int numSpecialEquivGroups(vector<string>& A) {
        set<string> s;

        for(int i=0;i<A.size();++i) {
            string temp1 = "";
            string temp2 = "";
            
            for(int j=0;j<A[i].size();++j) {
                if(j % 2 == 0) {
                    temp1 += A[i][j];
                } else {
                    temp2 += A[i][j];
                }
            }
            
            sort(temp1.begin(), temp1.end());
            sort(temp2.begin(), temp2.end());
            
            s.insert(temp1 + temp2);
        }
        
        return s.size();
    }
};
