import java.util.Arrays;

public class Task4 {
    public static boolean isGeometricProgression(String numbers) {
        String[] no = numbers.split(",");
        int[] numbersArray = new int[numbers.split(",").length];

        for (int i = 0; i < numbersArray.length; i++){
            numbersArray[i] = Integer.parseInt(no[i]);
        }

        Arrays.sort(numbersArray);
        double progressionDenominator = numbersArray[1] / numbersArray[0];

        for (int i = 1 ; i < numbersArray.length; i++){
            if(numbersArray[i] != numbersArray[i-1] * progressionDenominator){
                //System.out.println("GeometricProgression: False");
                return false;
            }
        }

        //System.out.println("GeometricProgression: True");
        return true;

    }
}
