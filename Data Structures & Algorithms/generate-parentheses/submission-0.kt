class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        val cur = mutableListOf<Char>()

        fun dfs(i: Int, openCount: Int, closeCount: Int) {
            if (openCount + closeCount == n * 2) {
                result.add(cur.joinToString(""))
                return
            }

            if (openCount < n) {
                cur.add('(')
                dfs(i + 1, openCount + 1, closeCount)
                cur.removeLast()
            }

            if (closeCount < openCount) {
                cur.add(')')
                dfs(i + 1, openCount, closeCount + 1)
                cur.removeLast()
            }
        }

        dfs(0, 0, 0)

        return result
    }
}
