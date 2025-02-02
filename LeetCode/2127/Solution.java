class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegrees = new int[n];
        int[] depth = new int[n];
        for(int i=0;i<n;++i) {
            indegrees[favorite[i]]++;
            depth[i] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;++i) {
            if(indegrees[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            int next = favorite[node];
            indegrees[next]--;
            depth[next] = Math.max(depth[next], depth[node]+1);
            if(indegrees[next] == 0) {
                q.add(next);
            }
        }

        int maxCycle = 0;
        int result = 0;
        for(int i=0;i<n;++i) {
            if(indegrees[i] == 0) {
                continue;
            }

            int node = i;
            int length = 0;
            while(indegrees[node] != 0) {
                indegrees[node] = 0;
                length++;
                node = favorite[node];
            }

            if(length == 2) {
                maxCycle += depth[i] + depth[favorite[i]];
            } else {
                result = Math.max(result, length);
            }
        }
        return Math.max(result, maxCycle);
    }
}
