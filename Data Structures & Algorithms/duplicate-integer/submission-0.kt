class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        set.addAll(nums.toTypedArray())
        
        return set.count() != nums.size
    }
}
