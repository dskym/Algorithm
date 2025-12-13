class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Pair<String, String>> result = new ArrayList<>();
        int n = code.length;
        for(int i=0;i<n;++i) {
            if(code[i].matches("[a-zA-Z0-9_]+")
                && Set.of("electronics", "grocery", "pharmacy", "restaurant").contains(businessLine[i])
                && isActive[i]) {
                    result.add(new Pair(businessLine[i], code[i]));
                }
        }

        Collections.sort(result, 
            Comparator.comparing(Pair<String, String>::getKey)
                      .thenComparing(Pair<String, String>::getValue));
        
        return result.stream().map(p -> p.getValue()).toList();
    }
}
