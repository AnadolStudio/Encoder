package encoder

import encoder.implementation.MirrorEncoder
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class MirrorEncoderTest {
    companion object {
        private const val TEST_TEXT = "TEST_TEXT"
    }

    private val encoder = MirrorEncoder()

    @Test
    fun `mirror successful test`() {
        assertEquals("TXET_TSET", encoder.encode(TEST_TEXT))
    }

    @Test
    fun `mirror failure test`() {
        assertNotEquals(TEST_TEXT, encoder.decode(TEST_TEXT))
    }
}
