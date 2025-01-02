class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] preSum = new int[n];
        Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for(int i=0;i<n;++i) {
            if(vowelSet.contains(words[i].charAt(0)) && vowelSet.contains(words[i].charAt(words[i].length()-1))) {
                count++;
            }
            preSum[i] = count;
        }

        int m = queries.length;
        int[] result = new int[m];
        for(int i=0;i<m;++i) {
            if(queries[i][0] == 0) {
                result[i] = preSum[queries[i][1]];
            } else {
                result[i] = preSum[queries[i][1]]-preSum[queries[i][0]-1];
            }
        }
        return result;
    }
}
