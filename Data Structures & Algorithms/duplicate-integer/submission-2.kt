class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val ms = mutableSetOf<Int>()
        nums.forEach {
            if (ms.contains(it)) return true
            else ms.add(it)
        }
        return false
    }
}
