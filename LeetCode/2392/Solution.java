class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Map<Integer, List<Integer>> rowGraph = new HashMap<>();
        for(int i=0;i<rowConditions.length;++i) {
            List<Integer> node = rowGraph.getOrDefault(rowConditions[i][0], new ArrayList<>());
            node.add(rowConditions[i][1]);
            rowGraph.put(rowConditions[i][0], node);
        }

        Map<Integer, List<Integer>> colGraph = new HashMap<>();
        for(int i=0;i<colConditions.length;++i) {
            List<Integer> node = colGraph.getOrDefault(colConditions[i][0], new ArrayList<>());
            node.add(colConditions[i][1]);
            colGraph.put(colConditions[i][0], node);
        }

        int[] rowIndegrees = new int[k+1];
        for(int i=0;i<rowConditions.length;++i) {
            rowIndegrees[rowConditions[i][1]]++;
        }

        int[] colIndegrees = new int[k+1];
        for(int i=0;i<colConditions.length;++i) {
            colIndegrees[colConditions[i][1]]++;
        }

        Queue<Integer> tempQueue = new LinkedList<>();
        boolean[] visited = new boolean[k+1];

        Queue<Integer> rowQueue = new LinkedList<>();
        for(int i=1;i<=k;++i) {
            if(rowIndegrees[i] == 0) {
                rowQueue.add(i);
                tempQueue.add(i);
                visited[i] = true;
            }
        }
        for(int i=1;i<=k;++i) {
            if(tempQueue.isEmpty()) {
                return new int[0][0];
            }

            int t = tempQueue.poll();
            if(rowGraph.get(t) != null) {
                for(int j=0;j<rowGraph.get(t).size();++j) {
                    rowIndegrees[rowGraph.get(t).get(j)]--;
                }
            }

            for(int j=1;j<=k;++j) {
                if(rowIndegrees[j] == 0 && visited[j] == false) {
                    rowQueue.add(j);
                    tempQueue.add(j);
                    visited[j] = true;
                }
            }
        }

        tempQueue = new LinkedList<>();
        visited = new boolean[k+1];

        Queue<Integer> colQueue = new LinkedList<>();
        for(int i=1;i<=k;++i) {
            if(colIndegrees[i] == 0) {
                colQueue.add(i);
                tempQueue.add(i);
                visited[i] = true;
            }
        }
        for(int i=1;i<=k;++i) {
            if(tempQueue.isEmpty()) {
                return new int[0][0];
            }

            int t = tempQueue.poll();
            if(colGraph.get(t) != null) {
                for(int j=0;j<colGraph.get(t).size();++j) {
                    colIndegrees[colGraph.get(t).get(j)]--;
                }
            }

            for(int j=1;j<=k;++j) {
                if(colIndegrees[j] == 0 && visited[j] == false) {
                    colQueue.add(j);
                    tempQueue.add(j);
                    visited[j] = true;
                }
            }
        }

        int[] rowIndex = new int[k+1];
        for(int i=0;i<k;++i) {
            int node = rowQueue.poll();
            rowIndex[node] = i;
        }

        int[] colIndex = new int[k+1];
        for(int i=0;i<k;++i) {
            int node = colQueue.poll();
            colIndex[node] = i;
        }

        int[][] result = new int[k][k];
        for(int i=1;i<=k;++i) {
            result[rowIndex[i]][colIndex[i]] = i;
        }
        return result;
    }
}
