class Solution {
    public int maxChunksToSorted(int[] arr) {
        int temp = 0;
        int result = 0;
        int base = 1;
        for(int i=0;i<arr.length;++i) {
            temp = temp | (1 << arr[i]);
            base *= 2;
            if(base-1 == temp) {
                result++;
            }
        }
        return result;
    }
}

