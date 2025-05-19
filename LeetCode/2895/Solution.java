class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.reverse(processorTime);
        Collections.sort(tasks);

        int result = 0;
        for(int i=0;i<processorTime.size();++i) {
            for(int j=0;j<4;++j) {
                result = Math.max(result, tasks.get(4*i+j)+processorTime.get(i));
            }
        }
        return result;
    }
}
