class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        solve(s, 0, new ArrayList<String>());
        return result;        
    }

    public void solve(String s, int start, List<String> path) {
        if(start == s.length()) {
            result.add(new ArrayList(path));
        }

        for(int i=start+1;i<=s.length();++i) {
            if(isPalindrome(s, start, i-1)) {
                path.add(s.substring(start, i));
                solve(s, i, path);
                path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
