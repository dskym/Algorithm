class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> sets = new HashSet<>();
        for(int i=0;i<deadends.length;++i) {
            sets.add(deadends[i]);
        }

        if(sets.contains("0000")) {
            return -1;
        }

        int[] diff = new int[]{1, 10, 100, 1000};
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];

        queue.add(new Node("0000", 0));
        visited[0] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.getVal().equals(target)) {
                return node.getCount();
            }

            int v = Integer.parseInt(node.getVal());

            for(int j=0;j<diff.length;++j) {
                int base = 10*diff[j];
                int val = (v+diff[j]) % base + v / base * base;
                if(visited[val]) {
                    continue;
                }
                String temp = String.format("%04d", val);
                if(sets.contains(temp)) {
                    continue;
                }
                visited[val] = true;
                queue.add(new Node(temp, node.getCount()+1));
            }
            for(int j=0;j<diff.length;++j) {
                int base = 10*diff[j];
                int val = (v-diff[j]) >= 0 ? (v-diff[j]) % base + v / base * base : base+(v-diff[j]);
                String temp = String.format("%04d", val);
                if(visited[val]) {
                    continue;
                }
                if(sets.contains(temp)) {
                    continue;
                }
                visited[val] = true;
                queue.add(new Node(temp, node.getCount()+1));
            }
        }

        return -1;
    }
}

class Node {
    private String val;
    private int count;

    public Node(String val, int count) {
        this.val = val;
        this.count = count;
    }

    public String getVal() {
        return val;
    }

    public int getCount() {
        return count;
    }
}
