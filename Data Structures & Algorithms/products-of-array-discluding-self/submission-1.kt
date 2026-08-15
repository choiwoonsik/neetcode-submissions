class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val lr = IntArray(nums.size) { 0 }

        var s = 1
        lr[0] = nums[0]
        for (i in 1 until nums.size) {
            if (i == nums.size - 1) 
                lr[i] = lr[i - 1]
            else lr[i] = nums[i] * lr[i - 1]
        }

        var rl = nums[nums.size - 1]
        for (i in nums.size - 2 downTo 1) {
            // 왼쪽 누적곱 배열 * 오른쪽 누적곱 변수
            lr[i] = lr[i - 1] * rl
            rl *= nums[i]
        }
        lr[0] = rl

        return lr
    }
}
