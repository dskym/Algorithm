class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<edges.length;++i) {
            List<Integer> temp1 = graph.getOrDefault(edges[i][0], new ArrayList<>());
            temp1.add(edges[i][1]);
            graph.put(edges[i][0], temp1);

            List<Integer> temp2 = graph.getOrDefault(edges[i][1], new ArrayList<>());
            temp2.add(edges[i][0]);
            graph.put(edges[i][1], temp2);
        }

        int[] dist1 = new int[n + 1];
        int[] dist2 = new int[n + 1];
        int[] freq = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dist1[i] = Integer.MAX_VALUE;
            dist2[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.getTime()));
        queue.add(new Node(1, 0));
        dist1[1] = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            freq[node.getNode()]++;

            if(freq[node.getNode()] == 2 && node.getNode() == n) {
                return node.getTime();
            }

            List<Integer> child = graph.get(node.getNode());

            if(child == null) {
                continue;
            }

            for(int i=0;i<child.size();++i) {
                int neighbor = child.get(i);
                if(freq[neighbor] == 2) {
                    continue;
                }

                int nextTime = node.getTime();
                int mode = nextTime / change;
                if(mode % 2 == 1) {
                    nextTime = change*(mode+1)+time;
                } else {
                    nextTime = nextTime+time;
                }

                if(dist1[neighbor] > nextTime) {
                    dist2[neighbor] = dist1[neighbor];
                    dist1[neighbor] = nextTime;
                    queue.add(new Node(neighbor, nextTime));
                } else if(dist2[neighbor] > nextTime && dist1[neighbor] != nextTime) {
                    dist2[neighbor] = nextTime;
                    queue.add(new Node(neighbor, nextTime));
                }
            }
        }
        return 0;
    }
}

class Node {
    private int node;
    private int time;

    public Node(int node, int time) {
        this.node = node;
        this.time = time;
    }

    public int getNode() {
        return this.node;
    }

    public int getTime() {
        return this.time;
    }
}
