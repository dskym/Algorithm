class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;

        int result = 0;
        for(int i=1;i<=100000;++i) {
            n -= i;
            if(n < 0) {
                break;
            }
            result++;
        }
        return result;
    }
}
