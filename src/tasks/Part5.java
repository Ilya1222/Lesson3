package tasks;

/**
 * Created by DELL on 12.10.2018.
 */
public class Part5 {
    public static String toRoman(int value) {
        String[] arrayRoman = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
        int[] arrayArabian = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100};
        StringBuilder stringBuilder = new StringBuilder();
        for ( int i = arrayRoman.length - 1; i >= 0; i--) {
            while (value >= arrayArabian[i]) {
                stringBuilder.append(arrayRoman[i]);
                value -= arrayArabian[i];
            }
        }
        return stringBuilder.toString();
    }
    public static int toDecimal(String romanNumber) {
        int value = 0;
        int lastNumber = 0;
        String finish = romanNumber.toUpperCase();
        for (int x = finish.length() - 1; x >= 0; x--) {
            char symbol = finish.charAt(x);
            switch (symbol) {
                case 'C':
                    value = processDecimal(100, lastNumber, value);
                    lastNumber = 100;
                    break;

                case 'L':
                    value = processDecimal(50, lastNumber, value);
                    lastNumber = 50;
                    break;

                case 'X':
                    value = processDecimal(10, lastNumber, value);
                    lastNumber = 10;
                    break;

                case 'V':
                    value = processDecimal(5, lastNumber, value);
                    lastNumber = 5;
                    break;

                case 'I':
                    value = processDecimal(1, lastNumber, value);
                    lastNumber = 1;
                    break;
            }
        }
        return value;
    }
    private static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }


}