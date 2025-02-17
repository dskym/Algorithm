class Solution {
    private Set<String> result = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        boolean[] visited = new boolean[7];
        solve(tiles, 0, "", visited);
        return result.size()-1;
    }

    private void solve(String tiles, int index, String temp, boolean[] visited) {
        result.add(new String(temp));

        for(int i=0;i<tiles.length();++i) {
            if(visited[i] == false) {
                visited[i] = true;
                solve(tiles, index+1, temp + tiles.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
}
