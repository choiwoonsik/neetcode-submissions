class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val alphabet = IntArray(26)

        if (s.length != t.length) return false

        for(i in 0 until s.length) {
            alphabet[s[i] - 'a']++
            alphabet[t[i] - 'a']--
        }

        return !alphabet.any { it != 0 }
    }
}
