class Solution {
    fun numberOfArrays(s: String, k: Int): Int {
        val l = s.length
        val dp = IntArray(100001) {0}

        dp[l-1] = if(s[l-1] != '0') 1 else 0

        for(i in l-2 downTo 0) {
            if(s[i] == '0')
                continue

            var temp = if(s.substring(i).comp(k.toString()) <= 0) 1 else 0
            for(j in i+1 until l) {
                if(s.substring(i, j).comp(k.toString()) > 0)
                     break
                temp = (temp + dp[j]) % 1000000007
            }
            dp[i] = temp
        }

        return dp[0]
    }

    fun String.comp(other: String): Int {
        val la = this.length
        val lb = other.length

        if(la == 0 && lb == 0) {
            return 0
        }

        if(la > lb) {
            return 1
        } else if(la < lb) {
            return -1
        } else {
            if(this[0].compareTo(other[0]) > 0) {
                return 1
            } else if(this[0].compareTo(other[0]) < 0) {
                return -1
            } else {
                return this.substring(1).comp(other.substring(1))
            }
        }
    }
}
