package ua.com.fedotov.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceVerificatorTest {

    @Test
    void isCorrectBracketsEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> BalanceVerificator.isCorrectBrackets(""));
    }

    @Test
    void isCorrectBracketsNonBrackets() {
        assertThrows(IllegalArgumentException.class, () -> BalanceVerificator.isCorrectBrackets("[]a"));
    }

    @Test
    void isCorrectBracketsPassed() {
        assertEquals(-1, BalanceVerificator.isCorrectBrackets("({[]})"));
    }

    @Test
    void isCorrectBracketsFailedWrongTypeBracket() {
        assertEquals(4, BalanceVerificator.isCorrectBrackets("({[(]})"));
    }

    @Test
    void isCorrectBracketsFailedExtraBracket() {
        assertEquals(3, BalanceVerificator.isCorrectBrackets("({[}]})"));
    }

    @Test
    void isCorrectBracketsFailedManyWrongTypeBracket() {
        assertEquals(9, BalanceVerificator.isCorrectBrackets("{()[()((([()]}"));
    }

    @Test
    void isCorrectBracketsOneOpenBracket() {
        assertEquals(1, BalanceVerificator.isCorrectBrackets("{"));
    }

    @Test
    void isCorrectBracketsOneCloseBracket() {
        assertEquals(1, BalanceVerificator.isCorrectBrackets("}"));
    }
}