class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        List<Pair<Integer, Integer>> graph = new ArrayList<>();        
        for(int i=0;i<n;++i) {
            graph.add(new Pair(nums[i], i));
        }

        Collections.sort(graph, (a,b) -> a.getKey()-b.getKey());

        int[] result = new int[n];
        List<Integer> value = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        for(int i=0;i<graph.size();++i) {
            if(value.size() > 0 && Math.abs(graph.get(i).getKey()-value.get(value.size()-1)) > limit) {
                Collections.sort(value);
                Collections.sort(index);

                for(int j=0;j<index.size();++j) {
                    result[index.get(j)] = value.get(j);
                }

                value.clear();
                index.clear();
            }

            value.add(graph.get(i).getKey());
            index.add(graph.get(i).getValue());
        }

        Collections.sort(value);
        Collections.sort(index);

        for(int j=0;j<index.size();++j) {
            result[index.get(j)] = value.get(j);
        }
        
        return result;
    }
}
