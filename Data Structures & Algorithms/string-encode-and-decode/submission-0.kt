class Solution {

    fun encode(strs: List<String>): String {
        val sb = StringBuilder()
        for(str in strs) {
            val len = str.length
            sb.append("<").append(len).append(">").append(str)
        }

        if(strs.isEmpty()) return "<empty>"

        return sb.toString()
    }

    fun decode(str: String): List<String> {
        var remain = str
        val results = mutableListOf<String>()
        var base = 0

        if (str.equals("<empty>")) return listOf<String>()
        
        while (true) {
            val len = getLength(remain, base)
            val word = getWord(remain, len, base)
            
            results.add(word)
            
            val lenlen = len.toString().length
            
            if (base + len + lenlen + 2 == remain.length) break
            base = (base + len + lenlen + 2)
        }

        return results
    }

    private fun getLength(str: String, base: Int): Int {
        val end = str.indexOf(">", base)
        
        return str.substring(base + 1, end).toInt()
    }

    private fun getWord(str: String, len: Int, base: Int): String {
        val end = str.indexOf(">", base)

        return str.substring(end + 1, end + 1 + len)
    }
}
