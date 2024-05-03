class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int len = Math.min(v1.length, v2.length);
        for(int i=0;i<len;++i) {
            int r1 = Integer.parseInt(v1[i]);
            int r2 = Integer.parseInt(v2[i]);

            if(r1 > r2) {
                return 1;
            } else if(r1 < r2) {
                return -1;
            }
        }
        int i1 = len;
        while(i1 < v1.length) {
            int r1 = Integer.parseInt(v1[i1]);
            if(r1 != 0) {
                return 1;
            }
            i1++;
        }
        int i2 = len;
        while(i2 < v2.length) {
            int r2 = Integer.parseInt(v2[i2]);
            if(r2 != 0) {
                return -1;
            }
            i2++;
        }
        return 0;
    }
}
