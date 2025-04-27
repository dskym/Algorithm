class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int start = 1;
        for(int t : target) {
            while(start <= t) {
                if(t == start) {
                    result.add("Push");
                } else {
                    result.add("Push");
                    result.add("Pop");
                }
                start++;
            }
        }
        return result;
    }
}
