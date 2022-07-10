package encoder

import alpabet.Alphabet
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DigitalTest {
    companion object {
        private const val UPPERCASE_TEST_TEXT = "ABC"
        private const val LOWERCASE_TEST_TEXT = "abc"
        private const val DIFFERENT_CASE_TEST_TEXT = "Abc"
        private const val SENTENCE_TEST_TEXT = "Abc abc! Abc. aBC"

        private const val ENCODE_UPPERCASE_TEST_TEXT = "1.-2.-3."
        private const val ENCODE_LOWERCASE_TEST_TEXT = "1-2-3"
        private const val ENCODE_DIFFERENT_CASE_TEST_TEXT = "1.-2-3"
        private const val ENCODE_SENTENCE_TEST_TEXT = "1.-2.-3. 1-2-3! 1.-2.-3.. 1-2.-3."
    }

    private val alphabet = Alphabet.Base(listOf("A", "B", "C"))
    private val encoder = Encoder.Digital(alphabet)

    @Test
    fun `digital successful uppercase test`() {
        assertEquals(ENCODE_UPPERCASE_TEST_TEXT, encoder.encode(UPPERCASE_TEST_TEXT))
    }

    @Test
    fun `digital successful lowercase test`() {
        assertEquals(ENCODE_LOWERCASE_TEST_TEXT, encoder.encode(LOWERCASE_TEST_TEXT))
    }

    @Test
    fun `digital successful different case test`() {
        assertEquals(ENCODE_DIFFERENT_CASE_TEST_TEXT, encoder.encode(DIFFERENT_CASE_TEST_TEXT))
    }

    @Test
    fun `digital successful sentence test`() {
        assertEquals(ENCODE_SENTENCE_TEST_TEXT, encoder.encode(SENTENCE_TEST_TEXT))
    }
}
