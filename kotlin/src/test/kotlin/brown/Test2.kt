package brown

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test2 {
    @Test
    fun example() {
        assertEquals("1,234,567", Main2().solution("1234567"))
    }
    @Test
    fun minus() {
        assertEquals("-1", Main2().solution("-1"))
    }
    @Test
    fun minus1Comma() {
        assertEquals("-123,465", Main2().solution("-123465"))
    }
    @Test
    fun minus2Comma() {
        assertEquals("-1,023,465", Main2().solution("-1023465"))
    }
    @Test
    fun zero() {
        assertEquals("0", Main2().solution("0"))
    }
    @Test
    fun decimal() {
        assertEquals("-1,023,465.0", Main2().solution("-1023465.0"))
    }
    @Test
    fun mThousand() {
        assertEquals("-1,000", Main2().solution("-1000"))
    }
    @Test
    fun tenThousand() {
        assertEquals("-10,000", Main2().solution("-10000"))
    }
    @Test
    fun twelve() {
        assertEquals("12", Main2().solution("12"))
    }
    @Test
    fun nTwelve() {
        assertEquals("-12", Main2().solution("-12"))
    }
    @Test
    fun negativeLong() {
        assertEquals("-123,454,444,442.3456777", Main2().solution("-123454444442.3456777"))
    }
    @Test
    fun long() {
        assertEquals("123,454,444,442.3456777", Main2().solution("123454444442.3456777"))
    }
}