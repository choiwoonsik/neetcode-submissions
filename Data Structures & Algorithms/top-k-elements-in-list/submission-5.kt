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
        val topK = IntArray(k)
        var idx = 0
        for (freq in nums.size downTo 1) {
            for (num in frequentArr[freq]) {
                topK[idx++] = num
                if (idx == k) return topK
            }
        }

        return topK
    }
}
