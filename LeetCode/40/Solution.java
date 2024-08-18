class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for(int i=0;i<candidates.length;++i) {
            if(i > 0 && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(candidates[i] > target) {
                break;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(candidates[i]);
            solve(candidates, i, temp, candidates[i], target);
            temp.remove(temp.size()-1);
        }
        return result;
    }

    public void solve(int[] candidates, int index, List<Integer> tempList, int tempSum, int target) {
        if(tempSum == target) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for(int i=index+1;i<candidates.length;++i) {
            if(i > index+1 && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(tempSum+candidates[i] > target) {
                break;
            }
            tempList.add(candidates[i]);
            solve(candidates, i, tempList, tempSum+candidates[i], target);
            tempList.remove(tempList.size()-1);
        }
    }
}
