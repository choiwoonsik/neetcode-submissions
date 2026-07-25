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
        
        val frequentArr = Array<MutableList<Int>>(nums.size + 1) {mutableListOf()}

        numMap.map { (num, freq) -> 
            frequentArr[freq]!!.add(num)
        }
        val topK = mutableListOf<Int>()

        for (i in nums.size downTo 1) {
            if (frequentArr[i].isNotEmpty()) {
                topK.addAll(frequentArr[i])
            }
            if (topK.size >= k) break
        }

        return topK.toIntArray()
    }
}
