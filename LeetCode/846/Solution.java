class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);
        Map<Integer, Integer> m = new HashMap<>();

        for(int i=0;i<hand.length;++i) {
            m.put(hand[i], m.getOrDefault(hand[i], 0)+1);
        }

        for(int i=0;i<hand.length;++i) {
            if(m.containsKey(hand[i])) {
                for(int j=0;j<groupSize;++j) {
                    int temp = hand[i]+j;
                    if(m.containsKey(temp)) {
                        if(m.get(temp) > 1) {
                            m.put(temp, m.get(temp)-1);
                        } else if(m.get(temp) == 1) {
                            m.remove(temp);
                        }
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
