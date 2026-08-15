class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val zeroCount: Int = nums.count{ it -> it == 0}

        return if (zeroCount == 0) {
            noZero(nums)
        } else if (zeroCount == 1) {
            singleZero(nums)
        } else {
            IntArray(nums.size) { 0 } 
        }
    }

    private fun noZero(nums: IntArray): IntArray {
        var allMultiplyNum: Int = 1

        for (num in nums) {
            val nextNum = num
            allMultiplyNum *= nextNum
        }

        return nums.map { num -> allMultiplyNum / num }.toIntArray()
    }

    private fun singleZero(nums: IntArray): IntArray {
        var allMultiplyNum: Int = 1

        for (num in nums) {
            if (num == 0) continue
            val nextNum = num
            allMultiplyNum *= nextNum
        }

        return nums.map { if (it != 0) 0 else allMultiplyNum }.toIntArray()
    }
}
