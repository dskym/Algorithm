class Solution {
public:
    void duplicateZeros(vector<int>& arr) {
        vector<int> temp;
        
        int n = arr.size();
        int pos = 0;
        
        for(int i=0;pos<n;++i) {
            temp.push_back(arr[i]);
            pos++;
            
            if(arr[i] == 0 && pos < n) {
                temp.push_back(0);
                pos++;
            }            
        }
        
        arr = temp;
    }
};
