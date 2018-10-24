// Forward declaration of guess API.
// @param num, your guess
// @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
int guess(int num);

class Solution {
public:
    int guessNumber(int n) {
        long long int end = n;
        long long int start = 1;
        
        while(1) {
            long long int mid = (start + end) / 2;
            
            long long int check = guess(mid);
            
            if(check == 1) {
                start = mid + 1;
            } else if(check == -1) {
                end = mid - 1;                
            } else {
                return mid;
            }          
        }
    }
};
