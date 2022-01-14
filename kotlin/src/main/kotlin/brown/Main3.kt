package brown


class Structure(internal val cache: MutableMap<Int, Int> = mutableMapOf(),
                internal val history: MutableMap<Int, Int> = mutableMapOf(),
                internal var clock: Int=0
) {

    fun add(key: Int, value: Int) {
        cache[key] = value
        history[key] = clock
        clock++
    }

    fun get(key: Int): Int {
        val res = cache[key] ?: throw RuntimeException("The value of $key was not found.")
        history[key] = clock++
        return res
    }
    fun remove(key: Int): Int {
        val res = cache[key] ?: throw RuntimeException("The value of $key was not found.")
        cache.remove(key)
        history.remove(key)
        return res
    }

    fun evict() {
        if(cache.isEmpty())
            return
        var key = -1
        var time = Int.MAX_VALUE
        history.forEach {
            if(it.value < time) {
                key = it.key
                time = it.value
            }
        }
        remove(key)
    }

}

class Main3 {

    fun solution(A: Array<String>): IntArray {
        val res = mutableListOf<Int>()
        val structure = Structure()
        for(i in A.indices) {
            if(A[i].trim() == "exit")
                break
            else if(A[i].trim() == "evict") {
                structure.evict()
            } else if(A[i].startsWith("add")) {
                val firstSpace = A[i].indexOf(' ')
                val lastSpace = A[i].lastIndexOf(' ')
                val key = A[i].substring(firstSpace+1, lastSpace).toInt()
                val value = A[i].substring(lastSpace+1).toInt()
                structure.add(key, value)
            } else if(A[i].startsWith("get") || A[i].startsWith("remove")) {
                val key = A[i].substring(A[i].indexOf(' ') + 1).toInt()
                try {
                    if(A[i].startsWith("get")) {
                        res.add(structure.get(key))
                    } else {
                        res.add(structure.remove(key))
                    }
                } catch (exception: Exception) {
                    res.add(-1)
                }
            }
        }

        return res.toIntArray()
    }

}
/*
class Structure(internal val cache: MutableMap<Int, Int> = mutableMapOf(),
                internal val history: MutableMap<Int, Int> = mutableMapOf(),
                internal var clock: Int=0,
                internal val que: ArrayDeque<Pair<Int, Int>>
                = ArrayDeque<Pair<Int, Int>>()
) {

    fun add(key: Int, value: Int) {
        cache[key] = value
        history[key] = clock++
    }

    fun get(key: Int): Int {
        val res = cache[key] ?: throw RuntimeException("The value of $key was not found.")
        history[key] = clock++
        return res
    }
    fun remove(key: Int): Int {
        val res = cache[key] ?: throw RuntimeException("The value of $key was not found.")
        cache.remove(key)
        history.remove(key)
        return res
    }

    fun evict() {
        if(cache.isEmpty())
            return
        var key = -1
        var time = Int.MAX_VALUE
        history.forEach {
            if(it.value < time) {
                key = it.key
                time = it.value
            }
        }
        remove(key)
    }

}
 */