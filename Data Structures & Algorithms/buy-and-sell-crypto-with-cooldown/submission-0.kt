class Solution {
    private lateinit var dp: Array<IntArray>

    fun maxProfit(prices: IntArray): Int {
        dp = Array(2) { IntArray(prices.size) { - 1 } }
        return buyOrSell(prices, 0, true)
    }

    fun buyOrSell(prices: IntArray, index: Int, buyTime: Boolean): Int {
        if (index >= prices.size) return 0

        val state = if (buyTime) 0 else 1
        if (dp[state][index] != -1) return dp[state][index]

        dp[state][index] = if (buyTime) {
            max(
                -prices[index] + buyOrSell(prices, index + 1, false),
                buyOrSell(prices, index + 1, true)
            ) 
        } else {
            max(
                prices[index] + buyOrSell(prices, index + 2, true),
                buyOrSell(prices, index + 1, false)
            )
        }

        return dp[state][index]
    }
}