class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) }
        
        dp[0][0] = 1
        for (y in 0 .. m - 1) dp[y][0] = 1
        for (x in 0 .. n - 1) dp[0][x] = 1

        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }

        return dp[m-1][n-1]
    }
}
