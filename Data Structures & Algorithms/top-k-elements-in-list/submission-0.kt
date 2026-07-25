class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val numMap = mutableMapOf<Int, Int>()
        
        for (num in nums) {
            if (num in numMap) {
                numMap.put(num, numMap[num]!! + 1)
            } else {
                numMap.put(num, 1)
            }
        }
        
        return numMap.toList()
            .sortedByDescending { it.second }
            .take(k)
            .map { it.first }
            .toIntArray()
    }
}
