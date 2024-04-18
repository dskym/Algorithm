class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int n = gas.length;
        int start = 0;
        int curr = 0;

        for(int i=0;i<n;++i) {
            totalGas += gas[i];
            totalCost += cost[i];
            curr += (gas[i] - cost[i]);
            if(curr < 0) {
                start = i+1;
                curr = 0;
            }
        }

        return (totalGas < totalCost) ? -1 : start;
    }
}


