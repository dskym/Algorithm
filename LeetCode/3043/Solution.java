class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> s1 = new HashSet<>();
        for(int arr : arr1) {
            while(arr != 0) {
                s1.add(arr);
                arr /= 10;
            }
        }

        Set<Integer> s2 = new HashSet<>();
        for(int arr : arr2) {
            while(arr != 0) {
                s2.add(arr);
                arr /= 10;
            }
        }

        int temp = 0;
        for(int s : s1) {
            if(s2.contains(s)) {
                temp = Math.max(temp, s);
            }
        }

        for(int s : s2) {
            if(s1.contains(s)) {
                temp = Math.max(temp, s);
            }
        }

        int result = 0;
        while(temp != 0) {
            result++;
            temp /= 10;
        }

        return result;
    }
}
