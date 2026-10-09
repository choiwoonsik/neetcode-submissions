class Solution {
    fun rob(nums: IntArray): Int {
        val len = nums.size
        var max: Int

        if (len == 1) return nums[0]

        // 막집 못감
        val dp = IntArray(len)

        dp[0] = nums[0]
        dp[1] = nums[1]
        max = max(dp[0], dp[1])

        for (i in 2 until len - 1) {
            if (i == 2) dp[2] = dp[0] + nums[2]
            else {
                dp[i] = max(dp[i - 2] + nums[i], dp[i - 3] + nums[i])
            }
            max = max(dp[i], max)
        }

        // 첫집 못감
        val dpp = IntArray(len)

        dpp[0] = 0
        dpp[1] = nums[1]

        for (i in 2 until len) {
            if (i == 2) dpp[2] = dpp[0] + nums[2]
            else {
                dpp[i] = max(dpp[i - 2] + nums[i], dpp[i - 3] + nums[i])
            }
            max = max(dpp[i], max)
        }

        return max
    }
}
