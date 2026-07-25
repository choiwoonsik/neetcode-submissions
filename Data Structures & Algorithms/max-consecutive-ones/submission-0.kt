class Solution {
    val one = 1
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0
        var accumulate = 0
        for(i in nums) {
            if (i == one) {
                accumulate++
            } else {
                max = Math.max(max, accumulate)
                accumulate = 0
            }
        }
        max = Math.max(max, accumulate)

        return max
    }
}
