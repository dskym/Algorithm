class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int result = 0;
        int empty = 0;
        while(numBottles > 0) {
            empty += numBottles;
            result += numBottles;
            numBottles = 0;

            while(empty >= numExchange) {
                numBottles++;
                empty -= numExchange;
                numExchange++;
            }
        }
        return result;
    }
}
