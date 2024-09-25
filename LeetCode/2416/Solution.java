class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie root = new Trie();
        int n = words.length;

        for(int i=0;i<n;++i) {
            String word = words[i];
            Trie temp = root;
            for(int j=0;j<word.length();++j) {
                int index = word.charAt(j)-'a';
                Trie[] tries = temp.getTries();

                Trie t = null;
                if(tries[index] == null){
                    t = new Trie();
                    t.setCount(1);
                } else {
                    t = tries[index];
                    t.setCount(t.getCount()+1);
                }

                temp.setTrie(index, t);
                temp = tries[index];
            }
        }

        int[] result = new int[n];

        for(int i=0;i<n;++i) {
            String word = words[i];
            Trie temp = root;
            for(int j=0;j<word.length();++j) {
                int index = word.charAt(j)-'a';
                Trie[] tries = temp.getTries();
                Trie t = tries[index];
                result[i] += t.getCount();
                temp = t;
            }
        }

        return result;
    }

    class Trie {
        private int count = 0;
        private Trie[] tries = new Trie[26];

        public int getCount() {
            return count;
        }

        public Trie[] getTries() {
            return tries;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setTrie(int index, Trie trie) {
            this.tries[index] = trie;
        }
    }
}
