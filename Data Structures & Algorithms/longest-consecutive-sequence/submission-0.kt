class Solution {
    fun longestConsecutive(nums: IntArray): Int {
    val numSet = nums.toHashSet()
    var maxLen = 0

    numSet.forEach { num ->
        if (!numSet.contains(num - 1)) {
            var next = num + 1
            var count = 1
            while (numSet.contains(next)) { 
                count++; 
                next++ 
            }
            maxLen = maxOf(maxLen, count)
        }
    }
    return maxLen
}
}
