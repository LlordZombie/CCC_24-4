package utilities;

public class ArrayUtilities {

    public static void printArray(int[][] a) {
        StringBuilder s = new StringBuilder();

        int longestLength = 1;
        for (int[] ints : a) {
            for (int anInt : ints) {
                if (String.valueOf(anInt).length() > longestLength) longestLength = String.valueOf(anInt).length();
            }
        }

        for (int[] ints : a) {
            for (int anInt : ints) {
                String formatString = String.format("%%%dd ", longestLength);
                s.append(String.format(formatString, anInt));
            }
            s.append('\n');
        }
        System.out.println(s);
    }


    public static boolean containsNot(char[][] a, char ch) {
        for (char[] y : a)
            for (char x : y) {
                if (x == ch) return false;
            }
        return true;
    }



}