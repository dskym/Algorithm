class Solution {
    public boolean checkPowersOfThree(int n) {
        if(n == 0) {
            return true;
        }

        if(n % 3 == 0) {
            return checkPowersOfThree(n / 3);
        }

        if((n-1) % 3 == 0) {
            return checkPowersOfThree(n-1);
        }

        return false;
    }
}
