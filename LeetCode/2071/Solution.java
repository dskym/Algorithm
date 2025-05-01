class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int start = 1;
        int end = Math.min(tasks.length, workers.length);
        int result = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(check(tasks, workers, pills, strength, mid)) {
                start = mid + 1;
                result = Math.max(mid, result);
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    private boolean check(int[] tasks, int[] workers, int pills, int strength, int mid) {
        int p = pills;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=workers.length-mid;i<workers.length;++i) {
            map.put(workers[i], map.getOrDefault(workers[i], 0)+1);
        }

        for(int i=mid-1;i>=0;--i) {
            Integer key = map.lastKey();
            if(key >= tasks[i]) {
                map.put(key, map.get(key)-1);
                if(map.get(key) == 0) {
                    map.remove(key);
                }
            } else {
                if(p == 0) {
                    return false;
                }
                key = map.ceilingKey(tasks[i]-strength);
                if(key == null) {
                    return false;
                }
                map.put(key, map.get(key)-1);
                if(map.get(key) == 0) {
                    map.remove(key);
                }
                p--;
            }
        }
        return true;
    }
}
