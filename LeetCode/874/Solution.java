class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, List<Integer>> row = new HashMap<>();
        Map<Integer, List<Integer>> col = new HashMap<>();

        Arrays.sort(obstacles, (a, b) -> a[1]-b[1]);
        for(int i=0;i<obstacles.length;++i) {
            List<Integer> temp = row.getOrDefault(obstacles[i][0], new ArrayList<>());
            temp.add(obstacles[i][1]);
            row.put(obstacles[i][0], temp);
        }

        Arrays.sort(obstacles, (a, b) -> a[0]-b[0]);
        for(int i=0;i<obstacles.length;++i) {
            List<Integer> temp = col.getOrDefault(obstacles[i][1], new ArrayList<>());
            temp.add(obstacles[i][0]);
            col.put(obstacles[i][1], temp);
        }

        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int x = 0;
        int y = 0;

        int result = 0;

        for(int i=0;i<commands.length;++i) {
            if(commands[i] == -1) {
                d = (d+1)%4;
            } else if(commands[i] == -2) {
                d--;
                if(d < 0) {
                    d = 3;
                }
            } else {
                int dx = x + direct[d][0]*commands[i];
                int dy = y + direct[d][1]*commands[i];

                System.out.println("x : " + x + ", y : " + y);

                if(d == 0 || d == 2) {
                    List<Integer> colList = row.get(x);
                    System.out.println(colList);
                    if(colList != null) {
                        for(int j=0;j<colList.size();++j) {
                            if(dy >= colList.get(j) && y < colList.get(j)) {
                                dy = colList.get(j)-1;
                                break;
                            } else if(dy <= colList.get(j) && y > colList.get(j)) {
                                dy = colList.get(j)+1;
                                break;
                            }
                        }
                    }
                } else {
                    List<Integer> rowList = col.get(y);
                    System.out.println(rowList);
                    if(rowList != null) {
                        for(int j=0;j<rowList.size();++j) {
                            if(dx >= rowList.get(j) && x < rowList.get(j)) {
                                dx = rowList.get(j)-1;
                                break;
                            } else if(dx <=rowList.get(j) && x > rowList.get(j)) {
                                dx = rowList.get(j)+1;
                                break;
                            }
                        }
                    }
                }

                x = dx;
                y = dy;
            }
            result = Math.max(x*x+y*y, result);
        }

        return result;
    }
}
