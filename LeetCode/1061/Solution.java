class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        for(int i=0;i<parent.length;++i) {
            parent[i] = i;
        }

        for(int i=0;i<s1.length();++i) {
            union(parent, s1.charAt(i), s2.charAt(i));
        }

        String result = "";
        for(int i=0;i<baseStr.length();++i) {
            char c = baseStr.charAt(i);
            result += (char)(find(parent, c)+'a');
        }
        return result;
    }

    private void union(int[] parent, char a, char b) {
        int pA = find(parent, a);
        int pB = find(parent, b);

        if(pA < pB) {
            parent[pB] = pA;
        } else {
            parent[pA] = pB;
        }
    }

    private int find(int[] parent, char a) {
        int index = a-'a';
        if(parent[index] == index) {
            return parent[index];
        }
        char c = (char)(parent[index]+'a');
        parent[index] = find(parent, c);
        return parent[index];
    }
}
