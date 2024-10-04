class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill);

        long temp = skill[0]+skill[n-1];
        for(int i=1;i<n/2;++i) {
            if(temp != skill[i]+skill[n-1-i]) {
                return -1;
            }
        }

        long result = 0;
        for(int i=0;i<n/2;++i) {
            result += skill[i] * skill[n-i-1];
        }
        return result;
    }
}
