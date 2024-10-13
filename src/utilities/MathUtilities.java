package utilities;

public class MathUtilities {
    public static int max(int... a) {
        if (a.length == 0) return 0;

        int max = a[0];
        for (int j : a) {
            if (j > max) max = j;
        }

        return max;
    }

    public static int min(int... a) {
        if (a.length == 0) return 0;

        int max = a[0];
        for (int j : a) {
            if (j < max) max = j;
        }

        return max;
    }

}
