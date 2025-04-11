class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int result = 0;
        for(int i=low;i<=high;++i) {
            if(i >= 10 && i <= 99) {
                if(i / 10 == i % 10) {
                    result++;
                }
            } else if(i >= 1000 && i <= 9999) {
                int front = i / 100;
                int back = i % 100;
                if(front / 10 + front % 10 == back / 10 + back % 10) {
                    result++;
                }
            }
        }
        return result;
    }
}
