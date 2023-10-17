import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void first_flattenMatrix() {
        int[][] arr = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] result = Task3.flattenMatrix(arr);
        int[] expected = new int[] {1, 4, 7, 2, 5, 8, 3, 6, 9};

        Assertions.assertArrayEquals(result, expected);
    }

    @Test
    void second_flattenMatrix(){
        int[][] arr = new int[][] {{1,2,3}, {12,14,6}, {18,16,9}};
        int[] result = Task3.flattenMatrix(arr);
        int[] expected = new int[]{1,12,18,2,14,16,3,6,9};

        Assertions.assertArrayEquals(result,expected);
    }
}