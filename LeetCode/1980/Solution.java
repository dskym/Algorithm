class Solution {
    private Set<String> set = new HashSet<>();
    public String findDifferentBinaryString(String[] nums) {
        for(String num : nums) {
            set.add(num);
        }

        return solve("", nums.length);
    }

    private String solve(String temp, int n) {
        if(n == 0) {
            if(set.contains(temp) == false) {
                return temp;
            } else {
                return "";
            }
        }

        String a = solve(temp + "0", n-1);
        if("".equals(a)) {
            return solve(temp + "1", n-1);
        }
        return a;
    }
}
