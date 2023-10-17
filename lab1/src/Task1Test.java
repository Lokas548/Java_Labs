import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    void shouldReturnTrue_ContainsDigitAInHexadecimalRepresentation() {
        boolean result = Task1.containsDigitAInHexadecimalRepresentation(10);
        assertTrue(result);
    }

    @Test
    void shouldReturnFalse_ContainsDigitAInHexadecimalRepresentation(){
        boolean result = Task1.containsDigitAInHexadecimalRepresentation(9);
        assertFalse(result);
    }
}