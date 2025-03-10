class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        Queue<Integer> pos = new LinkedList<>();
        int count = 0;

        int start = 0;
        int end = 0;
        int n = answerKey.length();

        int result = 0;
        while(end < n) {
            if(answerKey.charAt(end) == 'F') {
                count++;
                pos.add(end);
            }

            if(count > k) {
                result = Math.max(result, end-start);
                start = pos.poll()+1;
                count--;
            }

            end++;
        }

        if(count <= k) {
            result = Math.max(result, end-start);
        }

        pos.clear();
        start = 0;
        end = 0;
        count = 0;

        while(end < n) {
            if(answerKey.charAt(end) == 'T') {
                count++;
                pos.add(end);
            }

            if(count > k) {
                result = Math.max(result, end-start);
                start = pos.poll()+1;
                count--;
            }

            end++;
        }

        if(count <= k) {
            result = Math.max(result, end-start);
        }

        return result;
    }
}
