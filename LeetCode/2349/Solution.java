class NumberContainers {
    private Map<Integer, Integer> map;
    private Map<Integer, TreeSet<Integer>> setMap;

    public NumberContainers() {
        map = new HashMap<>();
        setMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(map.containsKey(index)) {
            int value = map.get(index);
            TreeSet<Integer> set = setMap.get(value);
            set.remove(index);
            setMap.put(value, set);
        }
        map.put(index, number);
        TreeSet<Integer> set = setMap.getOrDefault(number, new TreeSet<Integer>());
        set.add(index);
        setMap.put(number, set);
    }
    
    public int find(int number) {
        if(setMap.containsKey(number)) {
            if(setMap.get(number).size() == 0) {
                return -1;
            }
            return setMap.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
