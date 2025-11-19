class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        while(index < bits.length) {
            if(bits[index] == 1) {
                index++;
            } else {
                if(index == bits.length-1) {
                    return true;
                }
            }
            index++;
        }
        return false;
    }
}
