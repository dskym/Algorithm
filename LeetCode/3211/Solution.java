class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        result.add("0");
        result.add("1");
        for(int i=1;i<n;++i) {
            List<String> temp = new ArrayList<>(result);
            result.clear();
            for(int j=0;j<temp.size();++j) {
                if(temp.get(j).charAt(temp.get(j).length()-1) == '0') {
                    result.add(temp.get(j)+"1");
                } else {
                    result.add(temp.get(j)+"0");
                    result.add(temp.get(j)+"1");
                }
            }
        }
        return result;        
    }
}
