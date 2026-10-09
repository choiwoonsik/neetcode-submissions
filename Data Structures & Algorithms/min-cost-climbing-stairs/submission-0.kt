class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val len = cost.size
        val dp = IntArray(len + 1) { Integer.MAX_VALUE }

        dp[0] = cost[0]

        for (i in 1 .. len) {
            if (i == 1) dp[i] = min(dp[i - 1] + cost[i], cost[i])
            else if (i == len) dp[i] = min(dp[i - 1], dp[i - 2])
            else dp[i] = min(dp[i - 1] + cost[i], dp[i - 2] + cost[i])
        }

        return dp[len]
    }
}
