package brown

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Test1 {

    @Test
    fun test() {
        assertEquals(3, Main1().solution("foobarbaz"))
    }
    @Test
    fun testEmpty() {
        assertEquals(0, Main1().solution(""))
    }
    @Test
    fun testNonOverlapped() {
        assertEquals(0, Main1().solution("abcdefghi"))
    }
    @Test
    fun testJapanese() {
        assertEquals(0, Main1().solution("いろはにほへと"))
    }
    @Test
    fun testMono() {
        assertEquals(1, Main1().solution("aaaaa"))
    }
}
