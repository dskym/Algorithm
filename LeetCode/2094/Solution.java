class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<digits.length;++i) {
            for(int j=0;j<digits.length;++j) {
                for(int k=0;k<digits.length;++k) {
                    if(i == j || j == k || k == i) {
                        continue;
                    }

                    int temp = 100 * digits[i] + 10 * digits[j] + digits[k];
                    if(temp >= 100 && temp % 2 == 0) {
                        set.add(temp);
                    }
                }
            }
        }
        List<Integer> l = new ArrayList<>(set);
        Collections.sort(l);
        return l.stream().mapToInt(Integer::intValue).toArray();
    }
}
