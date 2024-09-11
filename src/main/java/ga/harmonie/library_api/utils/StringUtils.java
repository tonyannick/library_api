package ga.harmonie.library_api.utils;

import java.text.DecimalFormat;
import java.util.Random;

public final class StringUtils {

    private StringUtils() {
    }

    public static String generateRandomWord(int size) {
        var numbers = "0123456789";
        var alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var rnd = new Random();
        var stringBuilder = new StringBuilder(size);
        for (int i = 0; i < 3; i++){
            stringBuilder.append(numbers.charAt(rnd.nextInt(numbers.length())));
        }
        stringBuilder.append("-");
        for (int i = 0; i < size; i++){
            stringBuilder.append(alpha.charAt(rnd.nextInt(alpha.length())));
        }
        return stringBuilder.toString();
    }

    public static String generateRandomValue() {
        var df2 = new DecimalFormat("0.00");
        var min = 7.00;
        var max = 40.00;
        var rand = new Random().nextDouble();
        return df2.format(min + (rand * (max - min)));
    }

}
