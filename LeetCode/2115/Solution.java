class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        for(int i=0;i<recipes.length;++i) {
            for(int j=0;j<ingredients.get(i).size();++j) {
                List<String> l = graph.getOrDefault(ingredients.get(i).get(j), new ArrayList<>());
                l.add(recipes[i]);
                graph.put(ingredients.get(i).get(j), l);
                indegree.put(recipes[i], indegree.getOrDefault(recipes[i], 0)+1);
            }
        }

        Set<String> set = new HashSet<>();
        for(String recipe : recipes) {
            set.add(recipe);
        }

        Queue<String> q = new PriorityQueue<>((a,b)->indegree.getOrDefault(a,0)-indegree.getOrDefault(b,0));
        for(String supply : supplies) {
            q.add(supply);
        }

        List<String> result = new ArrayList<>();
        while(!q.isEmpty()) {
            String node = q.poll();
            if(graph.get(node) == null) {
                continue;
            }

            for(String next : graph.get(node)) {
                if(indegree.get(next) == null) {
                    continue;
                }
                indegree.put(next, indegree.get(next)-1);
                if(indegree.get(next) == 0) {
                    q.add(next);
                    if(set.contains(next)) {
                        result.add(next);
                    }
                }
            }
        }
        return result;
    }
}
