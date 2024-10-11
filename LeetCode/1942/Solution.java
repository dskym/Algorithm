class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        Integer[] index = new Integer[n];
        for(int i=0;i<n;++i) {
            index[i] = i;
        }
        
        Arrays.sort(index, (a, b) -> Integer.compare(times[a][0], times[b][0]));

        PriorityQueue<Integer> remainSeat = new PriorityQueue<>();
        for(int i=0;i<n;++i) {
            remainSeat.add(i);
        }

        PriorityQueue<int[]> occupySeat = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for(int i=0;i<n;++i) {
            int friend = index[i];
            int arrival = times[friend][0];
            int leave = times[friend][1];

            while(occupySeat.isEmpty() == false && occupySeat.peek()[0] <= arrival) {
                remainSeat.add(occupySeat.poll()[1]);
            }

            int seat = remainSeat.poll();

            if(friend == targetFriend) {
                return seat;
            }

            occupySeat.add(new int[]{leave, seat});
        }

        return -1;
    }
}
