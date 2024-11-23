class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;

        char[][] result = new char[m][n];
        for(int i=0;i<n;++i) {
            for(int j=m-1;j>=0;--j) {
                if(box[i][j] == '#') {
                    for(int k=j+1;k<m;++k) {
                        if(box[i][k] == '.') {
                            box[i][k-1] = '.';
                            box[i][k] = '#';
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                result[j][n-i-1] = box[i][j];
            }
        }
        return result;
    }
}
