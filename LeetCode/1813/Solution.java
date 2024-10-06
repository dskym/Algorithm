class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length() == sentence2.length()) {
            return sentence1.equals(sentence2);
        }

        String[] start = sentence1.split(" ");
        String[] end = sentence2.split(" ");

        List<String> prefix = new ArrayList<>();
        int i1 = 0, i2 = 0;
        while(i1 < start.length && i2 < end.length && start[i1].equals(end[i2])) {
            prefix.add(start[i1]);
            i1++;
            i2++;
        }

        List<String> suffix = new ArrayList<>();
        i1 = start.length-1;
        i2 = end.length-1;
        while(i1 >= 0 && i2 >= 0 && start[i1].equals(end[i2])) {
            suffix.add(start[i1]);
            i1--;
            i2--;
        }

        return start.length <= prefix.size()+suffix.size() || end.length <= prefix.size()+suffix.size();
    }
}
