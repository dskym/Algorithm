class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] cache = new boolean[numCourses][numCourses];

        for(int i=0;i<prerequisites.length;++i) {
            cache[prerequisites[i][0]][prerequisites[i][1]] = true;
        }

        for(int i=0;i<numCourses;++i) {
            for(int j=0;j<numCourses;++j) {
                for(int k=0;k<numCourses;++k) {
                    cache[j][k] = cache[j][k] || (cache[j][i] && cache[i][k]);
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(cache[query[0]][query[1]]);
        }
        return result;        
    }
}
