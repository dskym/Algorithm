class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] prime = new boolean[1000001];

        Arrays.fill(prime, true);
        prime[1] = false;
        for(int i=2;i<=Math.sqrt(right);++i) {
            for(int j=i*i;j<=right;j+=i) {
                prime[j] = false;
            }
        }


        List<Integer> primeList = new ArrayList<>();
        for(int i=left;i<=right;++i) {
            if(prime[i]) {
                primeList.add(i);
            }
        }

        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        int diff = right;
        for(int i=0;i<primeList.size()-1;++i) {
            int a = primeList.get(i);
            int b = primeList.get(i+1);

            if(a >= left && b <= right && diff > b-a) {
                result[0] = a;
                result[1] = b;
                diff = b-a;
            }
        }
        return result;
    }
}
