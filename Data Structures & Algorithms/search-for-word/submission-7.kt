// A B C E S E E E F S

// ["A","B","C","E"]
// ["S","F","E","S"]
// ["A","D","E","E"]

// ["A","B","C","E"]
// ["S","F","C","S"]
// ["A","D","E","E"]

class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val h = board.size
        val w = board[0].size
        var visited = Array(h) { BooleanArray(w) { false } }
        val dy = intArrayOf(0, 0, -1, 1)
        val dx = intArrayOf(-1, 1, 0, 0)
        var found = false

        fun dfs(cur: Dot) {
            if (cur.idx + 1 == word.length) {
                found = true
                return
            }

            for (d in 0 .. 3) {
                val ny = cur.y + dy[d]
                val nx = cur.x + dx[d]
                val ni = cur.idx + 1

                if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue
                if (board[ny][nx] != word[ni]) continue
                if (visited[ny][nx]) continue
                
                visited[ny][nx] = true
                dfs(Dot(ny, nx, ni))
                visited[ny][nx] = false
            }

            return
        }

        for (i in 0 until h) {
            for (j in 0 until w) {
                if (board[i][j] == word[0]) {
                    visited = Array(h) { BooleanArray(w) { false } }
                    visited[i][j] = true
                    found = false
                    dfs(Dot(i, j, 0))
                    if (found) return true
                }
            }
        }

        return false
    }

    data class Dot (
        val y: Int,
        val x: Int,
        val idx: Int
    )
}
