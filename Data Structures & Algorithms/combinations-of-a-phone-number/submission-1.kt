/*
2, 3, 4, 5, 6, 7, 8, 9
a  d  g  j  m  p  t  w
b  e  h  k  n  q  u  x
c  f  i  l  o  s  v  y z
*/

class Solution {
    fun letterCombinations(digits: String): List<String> {
        val result = mutableListOf<String>()
        val cur = mutableListOf<Char>()
        val alphaMap = mutableMapOf(
                2 to 'a', 3 to 'd', 4 to 'g', 
                5 to 'j', 6 to 'm', 7 to 'p', 
                8 to 't', 9 to 'w'
            )

        fun dfs(i: Int) {
            if (i == digits.length) {
                result.add(cur.joinToString(""))
                return
            }

            val digit = digits[i].digitToInt()
            val alpha = alphaMap[digit]!!
            val end = if (digit == 7 || digit == 9) 4 else 3

            for (c in 0 until end) {
                cur.add(alpha + c)
                dfs(i + 1)
                cur.removeLast()
            }
        }

        if (digits.isEmpty()) return emptyList()
        
        dfs(0)

        return result
    }
}
