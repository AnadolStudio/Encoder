package encoder

import alphabet.Alphabet
import encoder.implementation.DigitalEncoder
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DigitalTest {

    companion object {
        private const val UPPERCASE_TEST_LETTER = "A"
        private const val UPPERCASE_TEST_TEXT = "ABC"
        private const val LOWERCASE_TEST_TEXT = "abc"
        private const val DIFFERENT_CASE_TEST_TEXT = "Azc"
        private const val SENTENCE_TEST_TEXT = "Abc1 abc! ABC-abc"

        private const val ENCODE_UPPERCASE_TEST_LETTER = "1."
        private const val ENCODE_UPPERCASE_TEST_TEXT = "1.-2.-3."
        private const val ENCODE_LOWERCASE_TEST_TEXT = "1-2-3"
        private const val ENCODE_DIFFERENT_CASE_TEST_TEXT = "1.-26-3"
        private const val ENCODE_SENTENCE_TEST_TEXT = "1.-2-3{1} 1-2-3! 1.-2.-3.{-}1-2-3"
    }

    private val alphabet = Alphabet.Base(listOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
        "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"))
    private val encoder = DigitalEncoder(alphabet)

    @Test
    fun `digital encode successful uppercase letter`() {
        assertEquals(ENCODE_UPPERCASE_TEST_LETTER, encoder.encode(UPPERCASE_TEST_LETTER))
    }

    @Test
    fun `digital encode successful uppercase test`() {
        assertEquals(ENCODE_UPPERCASE_TEST_TEXT, encoder.encode(UPPERCASE_TEST_TEXT))
    }

    @Test
    fun `digital encode successful lowercase test`() {
        assertEquals(ENCODE_LOWERCASE_TEST_TEXT, encoder.encode(LOWERCASE_TEST_TEXT))
    }

    @Test
    fun `digital encode successful different case test`() {
        assertEquals(ENCODE_DIFFERENT_CASE_TEST_TEXT, encoder.encode(DIFFERENT_CASE_TEST_TEXT))
    }

    @Test
fun `digital encode successful sentence test`() {
        assertEquals(ENCODE_SENTENCE_TEST_TEXT, encoder.encode(SENTENCE_TEST_TEXT))
    }

    @Test
    fun `digital decode successful uppercase letter`() {
        assertEquals(UPPERCASE_TEST_LETTER, encoder.decode(ENCODE_UPPERCASE_TEST_LETTER))
    }

    @Test
    fun `digital decode successful uppercase test`() {
        assertEquals(UPPERCASE_TEST_TEXT, encoder.decode(ENCODE_UPPERCASE_TEST_TEXT))
    }

    @Test
    fun `digital decode successful lowercase test`() {
        assertEquals(LOWERCASE_TEST_TEXT, encoder.decode(ENCODE_LOWERCASE_TEST_TEXT))
    }

    @Test
    fun `digital decode successful different case test`() {
        assertEquals(DIFFERENT_CASE_TEST_TEXT, encoder.decode(ENCODE_DIFFERENT_CASE_TEST_TEXT))
    }

    @Test
    fun `digital decode successful sentence test`() {
        assertEquals(SENTENCE_TEST_TEXT, encoder.decode(ENCODE_SENTENCE_TEST_TEXT))
    }

}
