package brown

class Main1 {
// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

    fun solution(S: String): Int {
        val mp: MutableMap<Char, Int> = mutableMapOf()
        for(c in S) {
            mp[c] =  mp.getOrDefault(c, 0) + 1
        }
        var res = 0
        for(charCount in mp) {
            if(charCount.value > 1)
                res++
        }
        return res
    }

}