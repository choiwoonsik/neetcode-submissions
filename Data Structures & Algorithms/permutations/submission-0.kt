class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val cur = mutableListOf<Int>()
        val visited = BooleanArray(nums.size)

        fun dfs() {
            if (cur.size == nums.size) {
                result.add(cur.toList())
                return
            }

            for (i in 0 until nums.size) {
                if (!visited[i]) {
                    visited[i] = true
                    cur.add(nums[i])
                    dfs()
                    visited[i] = false
                    cur.removeLast()
                }
            }
        }

        dfs()

        return result
    }
}
