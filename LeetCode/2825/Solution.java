class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int index1 = 0;
        int index2 = 0;

        while(index1 < str1.length() && index2 < str2.length()) {
            System.out.println("1 : " + str1.charAt(index1) + ", 2 : " + str2.charAt(index2));
            if((str1.charAt(index1)-'a' == str2.charAt(index2)-'a'
            || (str1.charAt(index1)-'a'+1)%26 == str2.charAt(index2)-'a')) {
                index1++;
                index2++;
            } else {
                index1++;
            }
        }

        return index2 == str2.length();
    }
}
