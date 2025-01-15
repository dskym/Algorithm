class Solution {
    public int minimizeXor(int num1, int num2) {
        int result = num1;
        int count = 0;

        while(num2 != 0) {
            count += num2 % 2;
            num2 /= 2;
        }

        int temp = num1;
        while(temp != 0) {
            count -= temp % 2;
            temp /= 2;
        }

        int base = 1;
        if(count > 0) {
            while(count > 0) {
                if((num1 & base) == 0) {
                    result += base;
                    count--;
                }
                base *= 2;
            }
        } else {
            while(count < 0) {
                if((num1 & base) == base) {
                    result ^= base;
                    count++;
                }
                base *= 2;
            }
        }

        return result;
    }
}
