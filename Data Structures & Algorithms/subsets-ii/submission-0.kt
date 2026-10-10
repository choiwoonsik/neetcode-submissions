class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val sorted = nums.sorted()
        val result = mutableListOf<List<Int>>()
        val cur = mutableListOf<Int>()

        fun dfs(i: Int) {
            if (i == sorted.size) {
                result.add(cur.toList())
                return
            }

            if (i >= sorted.size) return
            
            cur.add(sorted[i])
            dfs(i + 1)

            var next = i
            cur.removeLast()
            while(next < sorted.size && sorted[next] == sorted[i]) next++
            dfs(next)
        }

        dfs(0)

        return result
    }
}
