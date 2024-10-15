class Solution {
    public long minimumSteps(String s) {
        long result = 0;
        int left = 0;
        int right = 0;
        char[] arr = s.toCharArray();
        while(right < arr.length) {
            if(arr[right] == '0') {
                while(left < right) {
                    if(arr[left] == '1') {
                        arr[left] = '0';
                        arr[right] = '1';
                        result += right-left;
                        break;
                    }
                    left++;
                }
            }
            right++;
        }
        return result;
    }
}
