class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        int[] count = new int[k];
        for(int i=0;i<n;++i) {
            count[((arr[i]%k)+k)%k]++;
        }
        

        for(int i=1;i<k;++i) {
            if(count[i] != count[k-i]) {
                return false;
            }
        }

        return (count[0] % 2 == 0) ? true : false;
    }
}

