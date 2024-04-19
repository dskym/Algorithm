class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        char[][] map = new char[numRows][1000];
        for(int i=0;i<numRows;++i) {
            for(int j=0;j<1000;++j) {
                map[i][j] = ' ';
            }
        }

        int index = 0;
        int row = 0;
        int col = 0;
        boolean direct = true;
        while(index < s.length()) {
            char c = s.charAt(index++);
            map[row][col] = c;
            if(direct) {
                if(row == numRows-1) {
                    direct = false;
                    row--;
                    col++;
                    continue;
                }
                row++;
            } else {
                if(row == 0) {
                    row++;
                    direct = true;
                    continue;
                }
                row--;
                col++;
            }
        }

        String result = "";
        for(int i=0;i<numRows;++i) {
            for(int j=0;j<1000;++j) {
                if(map[i][j] != ' ') {
                    result += map[i][j];
                }
            }
        }
        return result;
    }
}
