package brown

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.RuntimeException

class Test3 {

    @Test
    fun example() {
        assertEquals(
            intArrayOf(3, -1, 3).toList(),
            Main3().solution(
                arrayOf("add 5 3",  "add 1 2",  "get 5",
                    "evict",  "get 1",  "remove 5",  "exit",
                )
            ).toList()
        )
    }
    @Test
    fun unknown() {
        assertEquals(
            intArrayOf(3, -1, 3).toList(),
            Main3().solution(
                arrayOf("add 5 3",  "doge", "add 1 2",  "get 5",
                    "evict",  "get 1",  "remove 5",  "exit",
                )
            ).toList()
        )
    }

    @Test
    fun testAdd() {
        val res = Structure()
        res.add(1, 2)
        res.add(1, 3)
        assertEquals(mutableMapOf(1 to 3), res.cache)
        assertEquals(mutableMapOf(1 to 1), res.history)
    }

    @Test
    fun testGet() {
        val res = Structure()
        assertThrows<RuntimeException>{
            res.get(1)
        }
    }
    @Test
    fun evict() {
        val res = Structure()
        res.add(1,  2)
        res.add(2,  3)
        res.evict()
        assertThrows<RuntimeException>{
            res.get(1)
        }
        assertEquals(3, res.get(2))
    }
    @Test
    fun remove() {
        val res = Structure()
        res.add(1, 2)
        res.add(2,  3)
        assertEquals(3, res.remove(2))
    }
}