class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val wordMap = mutableMapOf<String, MutableList<Int>>()

        strs.forEachIndexed { index, word ->
            val sortedWord = word.toCharArray().sortedArray().concatToString()
            if (wordMap[sortedWord] == null) wordMap[sortedWord] = mutableListOf(index)
            else wordMap[sortedWord]!!.add(index)
        }

        return wordMap
            .map { (key, idxGroups) ->
                idxGroups.map { idx -> strs[idx] }
            }
    }
}
