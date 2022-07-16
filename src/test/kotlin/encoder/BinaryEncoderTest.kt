package encoder

import encoder.implementation.BinaryEncoder
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BinaryEncoderTest {
    companion object {
        private const val UPPERCASE_TEST_TEXT = "ABC"
        private const val LOWERCASE_TEST_TEXT = "abc"
        private const val DIFFERENT_CASE_TEST_TEXT = "Abc"
        private const val SENTENCE_TEST_TEXT = "Abc abc! Abc. aBC"
    }

    private val encoder = BinaryEncoder()

    private fun binaryCodeAndDecode(text: String): String = encoder.encode(text).let { encodeText ->
        encoder.decode(encodeText)
    }

    @Test
    fun `binary successful uppercase test`() {
        assertEquals(UPPERCASE_TEST_TEXT, binaryCodeAndDecode(UPPERCASE_TEST_TEXT))
    }

    @Test
    fun `binary successful lowercase test`() {
        assertEquals(LOWERCASE_TEST_TEXT, binaryCodeAndDecode(LOWERCASE_TEST_TEXT))
    }

    @Test
    fun `binary successful different case test`() {
        assertEquals(DIFFERENT_CASE_TEST_TEXT, binaryCodeAndDecode(DIFFERENT_CASE_TEST_TEXT))
    }

    @Test
    fun `binary successful sentence test`() {
        assertEquals(SENTENCE_TEST_TEXT, binaryCodeAndDecode(SENTENCE_TEST_TEXT))
    }

}
