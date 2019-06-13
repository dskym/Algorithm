class Solution {
public:
    vector<int> sumEvenAfterQueries(vector<int>& A, vector<vector<int>>& queries) {
        bool isEven[10001];
        int sum = 0;
                
        for(int i=0;i<A.size();++i) {
            if(A[i] % 2 == 0) {
                isEven[i] = true;
                sum += A[i];
            }
            else
                isEven[i] = false;
        }
        
        vector<int> result;
        
        for(int i=0;i<queries.size();++i) {
            int val = queries[i][0];
            int index = queries[i][1];

            A[index] += val;
                        
            if(isEven[index] && A[index] % 2 == 0) {
                sum += val;
            } else if(isEven[index] && A[index] % 2 != 0) {
                sum -= (A[index] - val);
                isEven[index] = false;
            } else if(!isEven[index] && A[index] % 2 == 0) {
                sum += A[index];
                isEven[index] = true;
            }
            
            result.push_back(sum);
        }
        
        return result;
    }
};:
