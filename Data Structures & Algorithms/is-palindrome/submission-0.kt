class Solution {
    fun isPalindrome(s: String): Boolean {
        val plain = s
            .lowercase()
            .map {
                if ((it in 'a'..'z') || (it in '0'..'9')) it
                else ""
            }.joinToString("")

        var left: String
        var right: String

        if (plain.length % 2 == 0) {
            left = plain.take(plain.length / 2)
            right = plain.substring(plain.length / 2).reversed()
        } else {
            left = plain.take(plain.length / 2)
            right = plain.substring(plain.length / 2 + 1).reversed()
        }

        return left == right
    }
}
