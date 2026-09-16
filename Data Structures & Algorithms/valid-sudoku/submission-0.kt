class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val squareMap = HashMap<Int, HashSet<Int>>()
        val horizontalMap = HashMap<Int, HashSet<Int>>()
        val verticalMap = HashMap<Int, HashSet<Int>>()

        for (y in board.indices) {
            for (x in board[y].indices) {
                val input = board[y][x]
                if (input == '.') continue

                val num = input - '0'

                val sy = y / 3
                val sx = x / 3

                val squareIdx = 3 * sy + sx
                val horizontalIdx = y
                val verticalIdx = x

                if (!squareMap.getOrPut(squareIdx) { HashSet() }.add(num)) return false
                if (!horizontalMap.getOrPut(horizontalIdx) { HashSet() }.add(num)) return false
                if (!verticalMap.getOrPut(verticalIdx) { HashSet() }.add(num)) return false
            }
        }

        return true
    }
}