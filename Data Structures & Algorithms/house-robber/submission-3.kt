class Solution {
    fun rob(nums: IntArray): Int {
        val len = nums.size
        val dp = IntArray(len)
        var max = 0

        if (len == 1) return nums[0]

        dp[0] = nums[0]
        dp[1] = nums[1]
        max = max(dp[0], dp[1])

        for (i in 2 .. len - 1) {
            if (i == 2) dp[2] = dp[0] + nums[i]
            else dp[i] = max(dp[i - 2] + nums[i], dp[i - 3] + nums[i])
            max = max(max, dp[i])
        }

        return max
    }
}
