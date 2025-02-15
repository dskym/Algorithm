class Solution {
    public int punishmentNumber(int n) {
        int result = 0;
        for(int i=1;i<=n;++i) {
            if(partSum(i*i, i, 0)) {
                result += i*i;
            }
        }
        return result;
    }

    private boolean partSum(int num, int target, int sum) {
        if(target == num + sum) {
            return true;
        }

        boolean result = false;
        int base = 10;
        while(num / base != 0) {
            result |= partSum(num % base, target, sum + num / base);
            base *= 10;
        } 

        return result;
    }
}

