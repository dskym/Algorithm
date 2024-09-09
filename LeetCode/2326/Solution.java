class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int width = n;
        int height = m-1;

        int x = 0;
        int y = 0;
        int d = 0;
        int count = 0;
        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] result = new int[m][n];
        for(int i=0;i<m;++i) {
            for(int j=0;j<n;++j) {
                result[i][j] = -1;
            }
        }

        while(head != null) {
            result[x][y] = head.val;
            count++;

            if((d == 0 || d == 2) && count == width) {
                width--;
                count = 0;
                d = (d+1)%4;
            } else if((d == 1 || d == 3) && count == height) {
                height--;
                count = 0;
                d = (d+1)%4;
            }

            x = x + direct[d][0];
            y = y + direct[d][1];
            head = head.next;
        }

        return result;
    }
}
