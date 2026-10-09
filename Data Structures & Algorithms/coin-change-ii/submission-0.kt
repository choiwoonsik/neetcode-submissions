class Solution {

    companion object {
        private var target: Int = 0
        private var dp: Array<IntArray> = arrayOf()
    }

    fun change(amount: Int, coins: IntArray): Int {
        target = amount
        dp = Array(coins.size) { IntArray(amount) { -1 } }

        fun dfs(index: Int, accumulate: Int): Int {
            if (accumulate > target) return 0
            if (index == coins.size) return 0

            if (accumulate == target) return 1
            if (dp[index][accumulate] != -1) return dp[index][accumulate]

            dp[index][accumulate] = 
                dfs(index, accumulate + coins[index]) + dfs(index + 1, accumulate)

            return dp[index][accumulate]
        }
        
        
        return dfs(0, 0)
    }
}

