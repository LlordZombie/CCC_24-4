import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StringsUtilities {

    public static boolean isRotatable(char[] a, char[] b) {
        int aLen = a.length;
        if (aLen != b.length) return false;

        LOOP:
        for (int bOffset = 0; bOffset < aLen; bOffset++) {
            for (int i = 0; i < aLen; i++) {
                if (a[i] != b[(i + bOffset) % aLen]) continue LOOP;
            }
            return true;
        }

        return false;
    }


    public static String reverse(String s) {
        StringBuilder r = new StringBuilder();
        for (int i = s.length() - 1; i > 0; i--) r.append(s.charAt(i));
        return r.toString();
    }

    public static String removeNoneLetters(String s) {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) r.append(s.charAt(i));
        }
        return r.toString();
    }

    public static String removeNoneDigits(String s) {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) r.append(s.charAt(i));
        }
        return r.toString();
    }

    public static String firstToUpperCase(String word) {
        return (String.valueOf(word.charAt(0))).toUpperCase() + (word.substring(1)).toLowerCase();
    }

    public static String remove(String s, String allowedChars) {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (allowedChars.contains(String.valueOf(s.charAt(i)))) r.append(s.charAt(i));
        }
        return r.toString();
    }

    public static int countOccurrences(String s, String part) {
        int counter = 0;
        for (int i = 0; i < (s.length() - part.length()); i++) {
            if (s.charAt(i) == part.charAt(0) && (s.substring(i, i + part.length())).contains(part)) counter++;
        }
        return counter;
    }

    public static String removeFirstOccurrence(String s, char ch) {
        if (!s.contains(String.valueOf(ch))) return s;
        return s.substring(0, s.indexOf(ch)) + s.substring(s.indexOf(ch) + 1);
    }

    public static boolean contains(char c, char... a) {
        for (char value : a) if (value == c) return true;
        return false;
    }

    Date StringToDate(String s) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = format.parse(s);
        return date;
    }

    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();




}
