class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val (t1, t2) = text1 to text2

        val dp = Array(t1.length + 1) { IntArray(t2.length + 1) { 0 } }

        for (i in 1 .. t1.length) {
            for (j in 1 .. t2.length) {
                val isSame = t1[i-1] == t2[j-1]
                if (isSame) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
                }
            }
        }

        return dp[t1.length][t2.length]
    }
}