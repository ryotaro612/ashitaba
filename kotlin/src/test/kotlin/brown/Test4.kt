package brown

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test4 {

    @Test
    fun example() {
        assertEquals(
            60,
            Main4().solution(intArrayOf(3, 1, 2, 5, 4)))
    }
    @Test
    fun zero() {
        assertEquals(
            0,
            Main4().solution(intArrayOf(-40, -10, 0, -10, -1)))
    }
    @Test
    fun pos() {
        assertEquals(
            -6,
            Main4().solution(intArrayOf(-1, -2, -3, -4, -5)))
    }
    @Test
    fun insufficient() {
        assertEquals(
            -1,
            Main4().solution(intArrayOf(-2, -3)))
    }
}