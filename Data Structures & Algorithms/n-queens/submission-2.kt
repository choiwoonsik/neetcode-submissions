class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val board = Array(n) { CharArray(n) { '.' } }
        val visited = Array(n) { IntArray(n) { 0 } }

        fun place(i: Int, j: Int, on: Int) {
            // 가로
            for (x in 0 until n) {
                visited[i][x] += on
            }

            // 세로
            for (y in 0 until n) {
                visited[y][j] += on
            }

            // 대각선 아래
            var rx = j
            var lx = j
            for (y in i + 1 until n) {
                if (rx + 1 < n) visited[y][++rx] += on
                if (lx - 1 >= 0) visited[y][--lx] += on
            }

            rx = j
            lx = j
            for (y in i - 1 downTo 0) {
                if (rx + 1 < n) visited[y][++rx] += on
                if (lx - 1 >= 0) visited[y][--lx] += on
            }
        }

        fun dfs(i: Int) {
            if (i == n) {
                result.add(board.map { it.joinToString("") })
                return
            }

            if (i > n) return
        
            for (j in 0 until n) {
                if (visited[i][j] == 0) {
                    // 놓고
                    place(i, j, 1)
                    // 탐색하고
                    board[i][j] = 'Q'
                    dfs(i + 1)
                    // 무르고
                    board[i][j] = '.'
                    place(i, j, -1)
                } else continue
            }
        }

        dfs(0)

        return result
    }
}
