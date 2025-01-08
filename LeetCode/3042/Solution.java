class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;

        int result = 0;
        for(int i=0;i<n;++i) {
            for(int j=i+1;j<n;++j) {
                if(isPrefixAndSuffix(words[i], words[j])) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isPrefixAndSuffix(String str1, String str2) {
        if(str1.length() > str2.length()) {
            return false;
        }

        for(int i=0;i<str1.length();++i) {
            if(str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        for(int i=0;i<str1.length();++i) {
            if(str1.charAt(i) != str2.charAt(i+str2.length()-str1.length())) {
                return false;
            }
        }

        return true;
    }
}
