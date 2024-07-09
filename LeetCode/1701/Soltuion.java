class Solution {
    public double averageWaitingTime(int[][] customers) {
        double result = 0.0;
        
        int time = 0;
        for(int i=0;i<customers.length;++i) {
            if(time <= customers[i][0]) {
                result += customers[i][1];
                time = customers[i][0]+customers[i][1];
            } else {
                result += (time - customers[i][0] + customers[i][1]);
                time += customers[i][1];
            }
        }
        return result / customers.length;
    }
}
