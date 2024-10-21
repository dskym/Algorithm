class Solution {
    public int maxUniqueSplit(String s) {
        return solve(s, new HashSet<>());
    }

    private int solve(String s, Set<String> set) {
        if(s.length() == 0) {
            return 0;
        }

        int result = 0;
        for(int i=1;i<=s.length();++i) {
            String sub = s.substring(0, i);
            String remain = s.substring(i, s.length());
            if(set.contains(sub) == false) {
                set.add(sub);
                result = Math.max(result, solve(remain, set)+1);
                set.remove(sub);
            }
        }
        return result;
    }
}
