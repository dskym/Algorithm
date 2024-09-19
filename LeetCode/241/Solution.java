class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }

    List<Integer> solve(String exp) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<exp.length();++i) {
            if(exp.charAt(i)=='+') {
                List<Integer> f = solve(exp.substring(0, i));
                List<Integer> e = solve(exp.substring(i+1));
                for(int a=0;a<f.size();++a) {
                    for(int b=0;b<e.size();++b) {
                        result.add(f.get(a)+e.get(b));
                    }
                }
            } else if(exp.charAt(i)=='-') {
                List<Integer> f = solve(exp.substring(0, i));
                List<Integer> e = solve(exp.substring(i+1));
                for(int a=0;a<f.size();++a) {
                    for(int b=0;b<e.size();++b) {
                        result.add(f.get(a)-e.get(b));
                    }
                }
            } else if(exp.charAt(i)=='*') {
                List<Integer> f = solve(exp.substring(0, i));
                List<Integer> e = solve(exp.substring(i+1));
                for(int a=0;a<f.size();++a) {
                    for(int b=0;b<e.size();++b) {
                        result.add(f.get(a)*e.get(b));
                    }
                }
            }
        }
        if(result.isEmpty()) {
            result.add(Integer.parseInt(exp));
        }
        return result;
    }
}
