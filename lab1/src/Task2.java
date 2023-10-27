import java.util.ArrayList;

public class Task2 {
    public static int[] segregateEvenAndOddNumbers(int[] array) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0; i < array.length;i++) {
            if (array[i] % 2 == 0) {
                even.add(array[i]);
            }
            else{
                odd.add(array[i]);
            }
        }
        even.addAll(odd);

       
        for (int i = 0; i < even.size();i++){
            array[i] = even.get(i);
        }

        return array;
    }
}
