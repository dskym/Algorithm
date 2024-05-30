class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] xor = new int[n];
        xor[0] = arr[0];
        for(int i=1;i<n;++i) {
            xor[i] = xor[i-1] ^ arr[i];
        }

        int count = 0;
        for(int i=0;i<n;++i) {
            for(int j=i+1;j<n;++j) {
                for(int k=j;k<n;++k) {
                    if(i == 0) {
                        if(xor[j-1] == (xor[k] ^ xor[j-1])) {
                            count++;
                        }
                    } else {
                        if((xor[j-1] ^ xor[i-1]) == (xor[k] ^ xor[j-1])) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
