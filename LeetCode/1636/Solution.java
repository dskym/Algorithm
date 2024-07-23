class Solution {
    public int[] frequencySort(int[] nums) {
        Arrays.sort(nums);
        List<Node> nodeList = new ArrayList<>();
        int count = 0;
        int base = -200;
        for(int i=0;i<nums.length;++i) {
            if(base != nums[i]) {
                nodeList.add(new Node(base, count));
                count = 1;
                base = nums[i];
            } else {
                count++;
            }
        }
        nodeList.add(new Node(base, count));

        Collections.sort(nodeList, (a, b) -> (a.getCount() == b.getCount()) ? b.getNum()-a.getNum() : a.getCount()-b.getCount());

        int[] result = new int[nums.length];
        int index = 0;
        for(int i=0;i<nodeList.size();++i) {
            Node node = nodeList.get(i);
            for(int j=0;j<node.getCount();++j) {
                result[index++] = node.getNum();
            }
        }
        return result;
    }
}

class Node {
    private int num;
    private int count;

    public Node(int num, int count) {
        this.num = num;
        this.count = count;
    }

    public int getNum() {
        return this.num;
    }

    public int getCount() {
        return this.count;
    }
}
