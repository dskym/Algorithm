class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n+1];

        for(int i=0;i<shifts.length;++i) {
            if(shifts[i][2] == 1) {
                diff[shifts[i][0]]++;
                diff[shifts[i][1]+1]--;
            } else {
                diff[shifts[i][0]]--;
                diff[shifts[i][1]+1]++;
            }
        }

        diff[0] = (diff[0] % 26);
        for(int i=1;i<n;++i) {
            diff[i] = (diff[i] + diff[i-1]) % 26;
        }

        StringBuffer result = new StringBuffer();
        for(int i=0;i<n;++i) {
            char c = (char)(s.charAt(i)+diff[i]);
            if(c >= 'a' && c <= 'z') {
                result.append(c);
            } else if(c < 'a') {
                result.append((char)('z'+c-'a'+1));
            } else if(c > 'z') {
                result.append((char)('a'+c-'z'-1));
            }
        }
        return result.toString();
    }
}
