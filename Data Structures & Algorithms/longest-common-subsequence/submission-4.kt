class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val (t1, t2) = 
            if (text1.length <= text2.length) text1 to text2 
            else text2 to text1

        val dp = Array(t1.length + 1) { IntArray(t2.length + 1) { 0 } }

        for (i in 1 .. t1.length) {
            for (j in 1 .. t2.length) {
                val isSame = t1[i-1] == t2[j-1]
                if (isSame) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
                }
                print("${dp[i][j]} ")
            }
            println();
        }

        return dp[t1.length][t2.length]
    }
}

//   b s b i n i n m
// j 0 0 0 0 0 0 0 0
// m 0 0 0 0 0 0 0 1
// j 0 0 0 0 0 0 0 1
// k 0 0 0 0 0 0 0 1
// b 1 1 1 1 1 1 1 2
// k
// j
// k
// v
//   c r a b t
// c 1 1 1 1 1
// a 1 1 2 2 2
// t 1 1 2 2 3

//   a b c c
// c 0 0 1 1
// c 0 0 1 2 
// b 0 1 1 2
// a 1 1 1 2
//   v o z s h
// p 0 0 0 0 0
// s 0 0 0 1 1
// n 0 0 0 0 1
// w 0 0 0 0 0