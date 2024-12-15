class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> Double.compare(calc(b.getKey(), b.getValue()), calc(a.getKey(), a.getValue())));
        for(int i=0;i<classes.length;++i) {
            pq.add(new Pair(classes[i][0], classes[i][1]));
        }

        for(int i=0;i<extraStudents;++i) {
            Pair<Integer, Integer> p = pq.poll();
            pq.add(new Pair(p.getKey()+1, p.getValue()+1));
        }

        double result = 0.0;
        while(!pq.isEmpty()) {
            Pair<Integer, Integer> p = pq.poll();
            result += (double)p.getKey()/p.getValue();
        }
        return result / classes.length;
    }

    private double calc(int a, int b) {
        return (a+1.0)/(b+1.0)-(double)a/b;
    }
}


