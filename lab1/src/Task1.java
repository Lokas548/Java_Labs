public class Task1 {
    public static boolean containsDigitAInHexadecimalRepresentation(int number) {
        final boolean contains = Integer.toHexString(number).toLowerCase().contains("a");
        //System.out.println("Contains А:" + contains);
        return contains;
    }

}
