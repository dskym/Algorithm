class Solution {
    public int minimumRecolors(String blocks, int k) {
        int result = 100;

        int start = 0;
        int end = 0;
        int count = 0;
        while(end < blocks.length()) {
            if(blocks.charAt(end) == 'W') {
                count++;
            }
            if(end-start+1 == k) {
                result = Math.min(count, result);

                if(blocks.charAt(start) == 'W') {
                    count--;
                }
                start++;
            }
            end++;
        }

        return result;
    }
}
