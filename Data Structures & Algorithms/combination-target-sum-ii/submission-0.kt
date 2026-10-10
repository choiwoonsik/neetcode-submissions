class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val sortNums =  candidates.sorted()
        val result = mutableListOf<List<Int>>()
        val curSet = mutableListOf<Int>()
        var curSum = 0

        fun dfs(i: Int) {
            if (curSum == target) {
                result.add(curSet.toList())
                return
            }
            
            if (i >= sortNums.size) return
            if (curSum > target) return

            curSum += sortNums[i]
            curSet.add(sortNums[i])
            dfs(i + 1)
            
            var next = i            
            curSum -= sortNums[i]
            curSet.removeLast()
            while (next < sortNums.size && sortNums[next] == sortNums[i]) next++
            dfs(next)
        }

        dfs(0)

        return result
    }
}
