class Solution {
    public int totalMoney(int n) {
        int result = 0;
        int base = 1;
        int count = base;
        for(int i=1;i<=n;++i) {
            result += count++;
            if(i % 7 == 0) {
                base++;
                count = base;
            }
        }
        return result;
    }
}
