class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val ms = mutableSetOf<Int>()

        nums.forEach { num ->
            if (ms.contains(num)) return true
            else ms.add(num)
        }

        return false
    }
}
