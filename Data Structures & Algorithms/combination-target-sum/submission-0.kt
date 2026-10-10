class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        var result = mutableListOf<List<Int>>()
        var cur = mutableListOf<Int>()

        fun dfs(i: Int, sum: Int) {
            if (i >= nums.size) return

            if (sum > target) return

            if (sum == target) {
                result.add(cur.toList())
                return
            }

            cur.add(nums[i])
            dfs(i, sum + nums[i])
            cur.removeLast()
            dfs(i + 1, sum)
        } 

        dfs(0, 0)

        return result
    }
}
