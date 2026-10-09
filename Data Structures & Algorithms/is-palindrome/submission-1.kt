class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (left < right) {
            left = getLeft(s, left)
            right = getRight(s, right)

            if (left >= s.length || right < 0) break

            if (s[left].lowercaseChar() == s[right].lowercaseChar()) {
                left++
                right--
            } else return false
        }

        return true
    }

    private fun getLeft(s: String, left: Int): Int {
        var l = left
        while (l < s.length) {
            if (s[l] in 'A' .. 'Z' || s[l] in 'a'..'z' || s[l] in '0'..'9') break
            else l += 1
        }

        return l
    }

    private fun getRight(s: String, right: Int): Int {
        var r = right
        while (r >= 0) {
            if (s[r] in 'A' .. 'Z' || s[r] in 'a'..'z' || s[r] in '0'..'9') break
            else r -= 1
        }

        return r
    }
}
