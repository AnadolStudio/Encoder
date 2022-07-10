package encoder

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class MirrorTest {
    companion object{
        private const val TEST_TEXT = "TEST_TEXT"
    }

    private val encoder = Encoder.Mirror()


    @Test
    fun `mirror successful test`() {
        assertEquals("TXET_TSET",encoder.encode(TEST_TEXT))
    }

    @Test
    fun `mirror failure test`() {
        assertNotEquals(TEST_TEXT,encoder.encode(TEST_TEXT))
    }
}
