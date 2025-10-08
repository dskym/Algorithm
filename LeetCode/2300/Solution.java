class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] result = new int[n];

        Arrays.sort(potions);

        for(int i=0;i<n;++i) {
            int start = 0;
            int end = potions.length-1;
            while(start <= end) {
                int mid = (start+end)/2;
                if(potions[mid]*(long)spells[i] < success) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
            result[i] = potions.length-start;
        }
        return result;
    }
}
