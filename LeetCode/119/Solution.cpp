class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> t;
        
        if(rowIndex == 0) {
            t.push_back(1);            
        } else if(rowIndex == 1) {
            t.push_back(1);
            t.push_back(1);            
        } else {
            t.push_back(1);
            t.push_back(1);

            for(int i=0;i<rowIndex-1;++i) {
                vector<int> a;
                a.push_back(1);

                for(int j=0;j<t.size()-1;++j) {
                    a.push_back(t[j]+t[j+1]);
                }

                a.push_back(1);

                t = a;
            }
        }
        
        return t;
    }
};
