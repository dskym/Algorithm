class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> s = new HashSet<>();

        int n = A.length;
        int[] result = new int[n];
        for(int i=0;i<n;++i) {
            int count = 0;
            s.add(A[i]);
            for(int j=0;j<=i;++j) {
                if(s.contains(B[j])) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
