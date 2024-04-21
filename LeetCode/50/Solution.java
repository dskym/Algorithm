class Solution {
    Map<Integer, Double> dp = new HashMap<>();
    public double myPow(double x, int n) {
        if(n == 1) {
            return x;
        } else if(n == -1) {
            return 1.0/x;
        } else if(n == 0) {
            return 1;
        }

        if(dp.containsKey(n) == false) {
            double result = myPow(x, n/2) * myPow(x, n-n/2);
            dp.put(n, result);
            return result;
        } else {
            return dp.get(n);
        }
    }
}
