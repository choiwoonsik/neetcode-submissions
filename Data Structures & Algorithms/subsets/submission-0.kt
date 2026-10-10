class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val cur = mutableListOf<Int>()

        fun dfs(index: Int) {
            if (index == nums.size) {
                result.add(cur.toList())
                return
            }
            
            cur.add(nums[index])
            dfs(index + 1)
            cur.removeLast()
            dfs(index + 1)
        }

        dfs(0)

        return result
    }
}
