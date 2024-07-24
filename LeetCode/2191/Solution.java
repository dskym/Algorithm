class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<nums.length;++i) {
            if(nums[i] == 0) {
                list.add(new Pair(nums[i], mapping[0]));
                continue;
            }
            int base = 1;
            int num = nums[i];
            int temp = 0;
            while(num != 0) {
                temp += mapping[num % 10] * base;
                base *= 10;
                num /= 10;
            }
            list.add(new Pair(nums[i], temp));
        }

        Collections.sort(list, (a, b) -> a.getJumbleNum() - b.getJumbleNum());

        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;++i) {
            result[i] = list.get(i).getNum();
        }
        return result;
    }
}

class Pair {
    int num;
    int jumbleNum;

    public Pair(int num, int jumbleNum) {
        this.num = num;
        this.jumbleNum = jumbleNum;
    }

    public int getNum() {
        return this.num;
    }

    public int getJumbleNum() {
        return this.jumbleNum;
    }
}
