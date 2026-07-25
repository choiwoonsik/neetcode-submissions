class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val wordCountMap = mutableMapOf<Map<Char, Int>, MutableList<Int>>()

        strs.forEachIndexed { index, word ->
            val charCountMap = word.groupingBy { it }.eachCount()

            if (wordCountMap[charCountMap] == null) wordCountMap[charCountMap] = mutableListOf(index)
            else wordCountMap[charCountMap]!!.add(index)
        }

        return wordCountMap
            .map { (key, idxGroups) ->
                idxGroups.map { idx -> strs[idx] }
            }
    }
}
