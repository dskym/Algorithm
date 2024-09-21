class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        int m = Math.min(n, 9);
        for(int i=1;i<=m;++i) {
            solve(n, i);
        }
        return result;
    }

    private void solve(int n, int temp) {
        if(temp > n) {
            return;
        }

        result.add(temp);

        for(int i=0;i<10;++i) {
            solve(n, 10*temp+i);
        }
    }
}
