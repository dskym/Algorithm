class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        List<Work> workList = new ArrayList<>();
        for(int i=0;i<n;++i) {
            workList.add(new Work(difficulty[i], profit[i]));
        }

        Collections.sort(workList);

        Arrays.sort(worker);

        int result = 0;
        int index = 0;
        int value = 0;
        for(int i=0;i<m;++i) {
            while(index < workList.size() && workList.get(index).getDifficulty() <= worker[i]) {
                value = Math.max(value, workList.get(index).getProfit());
                index++;
            }
            result += value;
        }

        return result;
    }
}

class Work implements Comparable<Work> {
    private int difficulty;
    private int profit;

    public Work(int difficulty, int profit) {
        this.difficulty = difficulty;
        this.profit = profit;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public int getProfit() {
        return this.profit;
    }

    @Override
    public int compareTo(Work work) {
        if(this.difficulty > work.getDifficulty()) {
            return 1;
        } else if(this.difficulty < work.getDifficulty()) {
            return -1;
        }
        if(this.profit > work.getProfit()) {
            return 1;
        } else if(this.profit < work.getProfit()) {
            return -1;
        }
        return 0;
    }
}

