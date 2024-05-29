class Solution {
    public int numSteps(String s) {
        int count = 0;
        while(true) {
            System.out.println(s);
            if(s.length() == 1 && s.charAt(0) == '1') {
                break;
            }
            if(s.length() > 1 && s.charAt(s.length()-1) == '0') {
                s = divideTwo(s);
            } else {
                s = addOne(s);
            }
            count++;
        }
        return count;
    }

    private String divideTwo(String s) {
        return s.substring(0, s.length()-1);
    }

    private String addOne(String s) {
        String result = "";
        int carry = 1;
        for(int i=s.length()-1;i>=0;--i) {
            int temp = (s.charAt(i) == '1' ? 1 : 0) + carry;
            result = Integer.toString(temp % 2) + result;
            carry = temp / 2;
        }
        if(carry == 1) {
            result = "1" + result;
        }
        return result;
    }
}
