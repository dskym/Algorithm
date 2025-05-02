class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] force = new int[n];

        int temp = 0;
        for(int i=0;i<n;++i) {
            if(dominoes.charAt(i) == 'R') {
                temp = n;
            } else if(dominoes.charAt(i) == 'L') {
                temp = 0;
            } else {
                temp = Math.max(temp-1, 0);
            }
            force[i] += temp;
        }

        temp = 0;
        for(int i=n-1;i>=0;--i) {
            if(dominoes.charAt(i) == 'L') {
                temp = n;
            } else if (dominoes.charAt(i) == 'R') {
                temp = 0;
            } else {
                temp = Math.max(temp-1, 0);
            }
            force[i] -= temp;
        }

        String result = "";
        for(int i=0;i<n;++i) {
            if(force[i] > 0) {
                result += "R";
            } else if(force[i] < 0) {
                result += "L";
            } else {
                result += ".";
            }
        }
        return result;
    }
}
