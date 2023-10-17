import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void first_isGeometricProgression() {
        String progression = "2,4,8,16";
        boolean result = Task4.isGeometricProgression(progression);
        assertTrue(result);
    }

    @Test
    void second_isGeometricProgression() {
        String progression = "1,2,4,5,6,22,1256";
        boolean result = Task4.isGeometricProgression(progression);
        assertFalse(result);
    }
}