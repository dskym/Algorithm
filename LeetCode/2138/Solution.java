class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> list = new ArrayList<>();
        int length = s.length();
        if(length % k != 0) {
            for(int i=0;i<k-length%k;++i) {
                s += fill;
            }
        }

        for(int i=0;i<s.length()/k;++i) {
            String temp = "";
            for(int j=0;j<k;++j) {
                temp += s.charAt(i*k+j);
            }
            list.add(temp);
        }

        String[] result = new String[list.size()];
        for(int i=0;i<list.size();++i) {
            result[i] = list.get(i);
        }
        return result;
    }
}
