class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        int base = 0;
        for(int i=0;i<n;++i) {
            if(grumpy[i] == 0) {
                base += customers[i];
            }
        }

        int temp = 0;
        for(int i=0;i<minutes;++i) {
            if(grumpy[i] == 1) {
                temp += customers[i];
            }
        }
        base += temp;

        int result = base;
        for(int i=minutes;i<n;++i) {
            if(grumpy[i] == 1) {
                base += customers[i];
            }
            if(grumpy[i-minutes] == 1) {
                base -= customers[i-minutes];
            }
            result = Math.max(result, base);
        }
        return result;
    }
}
