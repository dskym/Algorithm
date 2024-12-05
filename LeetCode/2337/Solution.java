class Solution {
    public boolean canChange(String start, String target) {
        int s = 0;
        int e = 0;
        while(s < start.length() || e < target.length()) {
            while(s < start.length() && start.charAt(s) == '_') {
                s++;
            }
            while(e < start.length() && target.charAt(e) == '_') {
                e++;
            }

            if(s == start.length() || e == target.length()) {
                break;
            }

            if(start.charAt(s) != target.charAt(e)) {
                return false;
            }

            if(start.charAt(s) == 'L' && s < e) {
                return false;
            }

            if(start.charAt(s) == 'R' && s > e) {
                return false;
            }

            e++;
            s++;
        }

        return s == start.length() && e == target.length();
    }
}
