class Solution {
public:
    int orderOfLargestPlusSign(int N, vector<vector<int>>& mines) {
        int arr[501][501];
        
        for(int i=0;i<N;++i)
            for(int j=0;j<N;++j)
                arr[i][j] = 1;
        
        for(int i=0;i<mines.size();++i) {
            int x = mines[i][0];
            int y = mines[i][1];
            
            arr[x][y] = 0;
        }
        
        int result = 0;
        
        for(int i=0;i<N;++i) {
            for(int j=0;j<N;++j) {
                if(arr[i][j] == 0)
                    continue;
                
                int k = 1;
                
                while(true) {
                    if(i + k < N && i - k >= 0 && j + k < N && j - k >= 0
                      && arr[i+k][j] == 1 && arr[i-k][j] == 1 && arr[i][j+k] == 1 && arr[i][j-k] == 1) {
                        k++;
                    } else {
                        break;
                    }
                }
                
                result = max(result, k);
            }
        }
        
        return result;
    }
};
