import java.util.ArrayList;

public class Task3 {
    public static int[] flattenMatrix(int[][] matrix) {
        int[] flattenMatrixArray  = new int[matrix.length * matrix.length];
        ArrayList<Integer> numbersList = new ArrayList<>();
        int i = 0;
        while (i != matrix.length) {
            for (int j = 0; j < matrix.length; j++) {
                numbersList.add(matrix[j][i]);
            }
            i++;
        }

        //System.out.println("Flatten matrix:");
        for (int j = 0; j < numbersList.size();j++){
            flattenMatrixArray[j] = numbersList.get(j);
            //System.out.println(flattenMatrixArray[j]);
        }

        return flattenMatrixArray;

    }
}
