class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val sMap = mutableMapOf<Char, Int>()
        val tMap = mutableMapOf<Char, Int>()

        if (s.length != t.length) return false

        for (i in 0 until s.length) {
            val sc = s[i]
            val tc = t[i]

            if (sMap.containsKey(sc)) sMap.put(sc, sMap.get(sc)!! + 1) else sMap.put(sc, 1)
            if (tMap.containsKey(tc)) tMap.put(tc, tMap.get(tc)!! + 1) else tMap.put(tc, 1)
        }

        sMap.keys.forEach { key ->
            if (sMap[key] != tMap[key]) return false
        }

        return true
    }
}
