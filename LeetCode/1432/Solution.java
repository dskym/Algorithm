class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        int index = 0;
        while(index < s.length() && s.charAt(index) == '9') {
            index++;
        }

        String a = s;
        if(index < s.length()) {
            a = s.replace(s.charAt(index), '9');
        }

        String b = s;
        if(s.charAt(0) != '1') {
            b = s.replace(s.charAt(0), '1');
        } else {
            index = 1;
            while(index < s.length() && (s.charAt(index) == '1' || s.charAt(index) == '0')) {
                index++;
            }
            if(index < s.length()) {
                b = s.replace(s.charAt(index), '0');
            }
        }

        return Integer.parseInt(a)-Integer.parseInt(b);
    }
}
