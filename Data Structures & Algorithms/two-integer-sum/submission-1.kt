class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val seen = mutableMapOf<Int, Int>() // value -> index

        for (idx in nums.indices) {
            val value = nums[idx]
            val complement = target - value
            seen[complement]?.let { complementIdx ->
                return intArrayOf(complementIdx, idx)
            }
            seen[value] = idx
        }

        return intArrayOf()
    }
}