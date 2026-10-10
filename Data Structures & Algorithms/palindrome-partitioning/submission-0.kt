class Solution {
    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val cur = mutableListOf<String>()

        fun dfs(i: Int) {
            if (i == s.length) {
                result.add(cur.toList())
                return
            }

            for (j in i + 1 .. s.length) {
                val sub = s.substring(i, j)
                if (isPalindrome(sub)) {
                    cur.add(sub)
                    dfs(j)
                    cur.removeLast()
                }
            }

            // dfs(i + 1)
        }

        dfs(0)

        return result
    }

    fun isPalindrome(s: String): Boolean {
        if (s.isEmpty()) return false

        for (i in 0 until s.length / 2) {
            if (s[i] == s[s.length - i - 1]) continue
            else return false
        }

        return true
    }
}
