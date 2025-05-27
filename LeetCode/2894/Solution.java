class Solution {
    public int differenceOfSums(int n, int m) {
        int temp = n / m;
        int num2 = temp*(temp+1)/2*m;
        return n*(n+1)/2-2*num2;
    }
}
