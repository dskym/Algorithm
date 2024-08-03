class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] test = new int[1001];

        for(int i=0;i<target.length;++i) {
            test[target[i]]++;
            test[arr[i]]--;
        }

        for(int i=0;i<1001;++i) {
            if(test[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
