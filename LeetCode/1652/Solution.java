class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        for(int i=0;i<n;++i) {
            if(k == 0) {
                result[i] = 0;
            } else if(k > 0) {
                int temp = 0;
                for(int j=0;j<k;++j) {
                    int index = (i+1+j)%n;
                    temp += code[index];
                }
                result[i] = temp;
            } else if(k < 0) {
                int temp = 0;
                for(int j=0;j<-k;++j) {
                    int index = (i-1-j)%n;
                    if(index < 0) {
                        index += n;
                    }
                    temp += code[index];
                }
                result[i] = temp;
            }
        }
        return result;
    }
}
