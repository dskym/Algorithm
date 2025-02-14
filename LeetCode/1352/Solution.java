class ProductOfNumbers {

    private List<Integer> list;
    private int temp = 1;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {
        temp *= num;
        list.add(temp);

        if(temp == 0) {
            list.clear();
            list.add(1);
            temp = 1;
        }
    }
    
    public int getProduct(int k) {
        if(list.size() <= k) {
            return 0;
        }

        return temp / list.get(list.size()-k-1);
    }
}

