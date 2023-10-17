import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class Task2Test {

    @Test
    void first_segregateEvenAndOddNumbers() {
        int arr[] = new int[]{8,2,3,4,5,6};
        int result[] = Task2.segregateEvenAndOddNumbers(arr);
        int expected[] = new int[]{8,2,4,6,3,5};

        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    void second_segregateEvenAndOddNumbers() {
        int arr[] = new int[]{2,1,4,6,8,12};
        int result[] = Task2.segregateEvenAndOddNumbers(arr);
        int expected[] = new int[]{2,4,6,8,12,1};

        Assertions.assertArrayEquals(expected,result);
    }
}