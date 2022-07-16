package encoder

import alphabet.Alphabet
import encoder.implementation.CaesarEncoder
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CaesarEncoderTest {
    companion object {
        private const val UPPERCASE_TEST_TEXT = "ABC"
        private const val LOWERCASE_TEST_TEXT = "abc"
        private const val DIFFERENT_CASE_TEST_TEXT = "Abc"
        private const val SENTENCE_TEST_TEXT = "Abc abc! Abc. aBC"

        private const val ENCODE_UPPERCASE_TEST_TEXT = "BCA"
        private const val ENCODE_LOWERCASE_TEST_TEXT = "bca"
        private const val ENCODE_DIFFERENT_CASE_TEST_TEXT = "Bca"
        private const val ENCODE_SENTENCE_TEST_TEXT = "Bca bca! Bca. bCA"
    }

    private val alphabet = Alphabet.Base(listOf("A", "B", "C"))
    private val encoder = CaesarEncoder(1, alphabet)

    @Test
    fun `caesar encode successful uppercase test`() {
        assertEquals(ENCODE_UPPERCASE_TEST_TEXT, encoder.encode(UPPERCASE_TEST_TEXT))
    }

    @Test
    fun `caesar encode successful lowercase test`() {
        assertEquals(ENCODE_LOWERCASE_TEST_TEXT, encoder.encode(LOWERCASE_TEST_TEXT))
    }

    @Test
    fun `caesar encode successful different case test`() {
        assertEquals(ENCODE_DIFFERENT_CASE_TEST_TEXT, encoder.encode(DIFFERENT_CASE_TEST_TEXT))
    }

    @Test
    fun `caesar encode successful sentence test`() {
        assertEquals(ENCODE_SENTENCE_TEST_TEXT, encoder.encode(SENTENCE_TEST_TEXT))
    }

    @Test
    fun `caesar decode successful uppercase test`() {
        assertEquals(UPPERCASE_TEST_TEXT, encoder.decode(ENCODE_UPPERCASE_TEST_TEXT))
    }

    @Test
    fun `caesar decode successful lowercase test`() {
        assertEquals(LOWERCASE_TEST_TEXT, encoder.decode(ENCODE_LOWERCASE_TEST_TEXT))
    }

    @Test
    fun `caesar decode successful different case test`() {
        assertEquals(DIFFERENT_CASE_TEST_TEXT, encoder.decode(ENCODE_DIFFERENT_CASE_TEST_TEXT))
    }

    @Test
    fun `caesar decode successful sentence test`() {
        assertEquals(SENTENCE_TEST_TEXT, encoder.decode(ENCODE_SENTENCE_TEST_TEXT))
    }

}
