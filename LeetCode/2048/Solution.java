class Solution {
    public int nextBeautifulNumber(int n) {
        for(int i=n+1;i<=1224444;++i) {
            if(isBalance(i)) {
                return i;
            }
        }
        return 0;       
    }

    private boolean isBalance(int n) {
        int[] count = new int[10];
        while(n != 0) {
            count[n%10]++;
            n /= 10;
        }
        for(int i=0;i<=9;++i) {
            if(count[i] != 0 && count[i] != i) {
                return false;
            }
        }
        return true;
    }
}
