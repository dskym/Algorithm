class Solution {
    public int maximumSwap(int num) {
        char[] temp = Integer.toString(num).toCharArray();
        int result = 0;
        for(int i=0;i<temp.length;++i) {
            char c = temp[i];
            int index = i;
            for(int j=temp.length-1;j>i;--j) {
                if(c < temp[j]) {
                    c = temp[j];
                    index = j;
                }
            }
            char t = temp[i];
            temp[i] = temp[index];
            temp[index] = t;

            result = Math.max(result, Integer.parseInt(new String(temp)));

            char tt = temp[i];
            temp[i] = temp[index];
            temp[index] = tt;
        }
        return result;
    }
}
