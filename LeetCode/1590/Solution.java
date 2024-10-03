class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        for(int i=0;i<n;++i) {
            nums[i] %= p;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] partialSum = new int[n];
        int temp = 0;
        for(int i=0;i<n;++i) {
            temp = (temp + nums[i]) % p;
            partialSum[i] = temp;

            List<Integer> l = map.getOrDefault(temp, new ArrayList<>());
            l.add(i);
            map.put(temp, l);
        }

        int base = partialSum[n-1] % p;
        if(base == 0) {
            return 0;
        }

        int result = 1000000001;
        for(int i=0;i<n-1;++i) {
            if(base == partialSum[i]) {
                result = Math.min(result, i+1);
            }
        }

        for(int i=0;i<n;++i) {
            int target = partialSum[i] - base;
            if(target < 0) {
                target += p;
            }

            if(map.get(target) == null) {
                continue;
            }

            for(int j=0;j<map.get(target).size();++j) {
                if(i >= map.get(target).get(j)) {
                    result = Math.min(result, i-map.get(target).get(j));
                }
            }
        }

        return (result == 1000000001) ? -1 : result;
    }
}

