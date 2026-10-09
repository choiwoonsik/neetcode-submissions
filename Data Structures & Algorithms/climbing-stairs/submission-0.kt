class Solution {
    fun climbStairs(n: Int): Int {
        val dp: IntArray = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1

        for (i in 1 .. n) {
            if (i == 1) dp[i] = dp[0]
            else dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[n]
    }
}
