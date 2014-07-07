package com.ievleva.util;


public class Converter {

    /**
     * Converts String into integer
     *
     * @param string string to convert
     * @return converted value
     */
    public int toInt(String string) {
        boolean isNegative = false;
        int result = 0;
        //  a0 * 10^0 + a1 * 10^1 + a2 * 10^2 + ... + an * 10 ^ n

        if (string.charAt(0) == '-') {
            string = string.substring(1, string.length());
            isNegative = true;
        }

        for (int i = 0; i < string.length(); i++) {
            result += ((string.charAt(i) - 48) * (int) Math.pow(10, (string.length() - 1 - i)));
        }

        return isNegative ? -result : result;
    }

    /**
     * Converts integer number into String
     *
     * @param number number to convert
     * @return converted value
     */
    public String toString(int number) {
        StringBuilder result = new StringBuilder();
        String minus = "";

        if (number < 0) {
            minus = "-";
            number = Math.abs(number);
        }
        if (number == 0) return "0";

        while (number > 0) {
            result.append(number % 10);
            number /= 10;
        }
        result.append(minus);
        result.reverse();
        return result.toString();
    }

    /**
     * Converts String into double number
     *
     * @param string string to convert
     * @return converted value
     */
    public double toDouble(String string) {
        boolean isNegative = false;
        double result = 0;

        if (string.charAt(0) == '-') {
            string = string.substring(1, string.length());
            isNegative = true;
        }
        int pointPosition = string.indexOf('.'); // узнаем сколько разрядов до точки

        // целая часть
        for (int i = 0; i < pointPosition; i++) {
            result += ((string.charAt(i) - 48) * (int) Math.pow(10, (pointPosition - 1 - i)));
        }
        int doubleLength = string.length() - pointPosition - 1; // длина дробной части дробного числа
        string = string.substring(pointPosition + 1, string.length());  // берем строку после запятой
        int doublePartToInt = toInt(string); // взяли и дробную часть числа сконвертировали в челую
        double doublePart = doublePartToInt * Math.pow(10, -doubleLength);// возвели в отрицательную степень. Вуаля
        result += doublePart;

        return isNegative ? -result : result;
    }

    /**
     * Converts double number into String
     *
     * @param number double number to convert
     * @return converted value
     */
    public String toString(double number) {
        StringBuilder result = new StringBuilder();
        boolean isNegative = false;

        // если число негативное добавляем минус
        if (number < 0) {
            isNegative = true;
            result.append("-");
            number = Math.abs(number);
        }
        // берем целую часть от дробного числа
        int intNumber = (int) number;

        // если целая часть равна ноль
        if (intNumber == 0) {
            result.append("0");
        }
        // индекс для точки
        int pointIdx = toString(intNumber).length() + (isNegative ? 1 : 0);

        // умножаем number на 1 000 000, приводим к int и конвертируем в сторку
        String string = toString((int) (number * 1000000));

        // количество нолей после запятой
        int zeros = 6 - string.length();

        for (int i = 0; i < zeros; i++) {
            result.append("0");
        }

        // отрезаем лишнии нолики
        for (int i = string.length() - 1, j = 0; i >= 0; i--) {
            if ('0' == string.charAt(i)) {
                j++;
            } else {
                result.append(string.substring(0, string.length() - j));
                break;
            }
        }

        // ставим точку
        result.insert(pointIdx, '.');

        return result.toString();
    }
}
