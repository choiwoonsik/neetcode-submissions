class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size)
        var prefix = 1
        for (i in nums.indices) {
            res[i] = prefix
            prefix *= nums[i]
        }

        var suffix = 1
        for (i in nums.indices.reversed()) {
            res[i] *= suffix
            suffix *= nums[i]
        }
        
        return res
    }
}
