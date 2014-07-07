package com.ievleva.util;


public class Logic {

    /**
     * Receives char array and prints it
     *
     * @param charArr Array of char
     */
    public void receiveAndPrintArrChar(char[] charArr) {
        for (int i = 0; i < charArr.length; ++i) {
            System.out.println(charArr[i]);
        }
    }

    /**
     * Prints Two-Dimensional Array of String
     *
     * @param stringToPrint Two-Dimensional Array of String
     */
    public static void printArray(String[][] stringToPrint) {
        for (int i = 0; i < stringToPrint.length; i++) {
            for (int j = 0; j < stringToPrint[i].length; j++) {
                System.out.println(stringToPrint[i][j]);
            }
        }
    }

    /**
     * Takes Two-Dimensional array of int and convert it to array of char
     * Each char in the position of array corresponds to int code
     *
     * @param intToConvert Two-Dimensional array of int
     * @return converted Two-Dimensional array of char
     */
    public char[][] convertIntToChar(int[][] intToConvert) {
        char[][] intToChar = new char[intToConvert.length][intToConvert.length];

        try {
            for (int i = 0; i < intToConvert.length; i++) {
                for (int j = 0; j < intToConvert[i].length; j++) {
                    intToChar[i][j] = (char) intToConvert[i][j];
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You should pass array n * n.");
        }
        return intToChar;
    }

    /**
     * Inverts array of integer numbers
     *
     * @param intToConvert Two-Dimensional array of int
     */
    public void invertInt(int[][] intToConvert) {
        for (int i = 0; i < intToConvert.length; i++) {
            for (int j = 0; j < intToConvert[i].length; j++) {
                intToConvert[i][j] *= -1;
            }
        }
    }

    /**
     * Takes two int parameters and returns the maximum value
     *
     * @param a int to compare
     * @param b int to compare
     * @return the maximum int value
     */
    public int compareInt(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * Takes three int parameters and returns the maximum value
     *
     * @param a int to compare
     * @param b int to compare
     * @param c int to compare
     * @return the maximum int value
     */
    public int compareInt(int a, int b, int c) {
        return compareInt(compareInt(a, b), c);
    }

    /**
     * Takes five int parameters and returns the maximum value
     *
     * @param a int to compare
     * @param b int to compare
     * @param c int to compare
     * @param d int to compare
     * @param e int to compare
     * @return the maximum int value
     */
    public int compareInt(int a, int b, int c, int d, int e) {
        return compareInt(compareInt(a, b, c), d, e);
    }

    /**
     * Takes array of char
     *
     * @param chars array of char
     * @return string composed of array of char
     */
    public String charToString(char[] chars) {
        return String.valueOf(chars);
    }

    /**
     * Checks if the second array contains the same sequence of characters as the first one
     *
     * @param chars  array of char
     * @param chars1 array of char
     * @return true if it contains, otherwise - false
     */
    public boolean doesContainCharSequence(char[] chars, char[] chars1) {
        boolean isContains = true;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == chars1[0]) {
                for (int j = 1; j < chars1.length; j++) {
                    if (chars[i + j] != chars1[j]) {
                        isContains &= false;
                    }
                }
                return isContains;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the key in the int array
     *
     * @param intArray     array of int
     * @param targetNumber key
     * @return index of key in the array or -1 if there is no such index
     */
    public int findElementInArrayFromBegin(int[] intArray, int targetNumber) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == targetNumber) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the key in the int array
     *
     * @param intArray     array of int
     * @param targetNumber key
     * @return index of key in the array or -1 if there is no such index
     */
    public int findElementInArray(int[] intArray, int targetNumber) {
        for (int i = intArray.length - 1; i < intArray.length; i--) {
            if (intArray[i] == targetNumber) {
                return (intArray.length - 1) - i;
            }
        }
        return -1;
    }

    /**
     * Returns factorial of an integer number
     */
    public int factorial(int number) {
        return number == 0 ? 1 :
                number * factorial(number - 1);
    }

    /**
     * Checks if the year is leap
     */
    public boolean isLeap(int year) {
        boolean result = false;

        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            result = true;
        }
        return result;
    }

    /**
     * Filters Array of strings by string-filter
     *
     * @param stringsToFiler array of Strings to filter
     * @param filterStr      string-filter
     * @return array of filtered Strings
     */
    public String[] filterArrayStr(String[] stringsToFiler, String filterStr) {
        String[] res = new String[stringsToFiler.length];
        int counter = 0;

        for (int i = 0; i < stringsToFiler.length; i++) {
            if (stringsToFiler[i].contains(filterStr)) {

                res[counter] = stringsToFiler[i];
                counter++;
            }
        }

        String[] cutRes = new String[counter];

        for (int j = 0; j < counter; j++) {
            if (!(res[j] == null)) {
                cutRes[j] = res[j];
            }
        }
        return cutRes;
    }

    /**
     * Prints array of numbers which are multiple of filterNumb
     *
     * @param numbersToFiler array of integer numbers
     * @param filterNumb     filter
     */
    public void filterArrayInt(int[] numbersToFiler, int filterNumb) {
        for (int number : numbersToFiler) {
            if ((number % filterNumb) == 0) {
                System.out.println(number + " is  multiple of " + filterNumb);
            }
        }
    }

    /**
     * Sorts numbers
     *
     * @param a         array to sort
     * @param wayToSort flag to choose sorting way
     *                  true - Sorting in ascending order
     *                  false - Sorting in decreasing order
     */
    public void sortInt(int[] a, boolean wayToSort) {
        if (wayToSort) {
            sortInt(a);
        } else {
            sortIntInverse(a);
        }
    }

    public int[] sortIntInverse(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }

            }
        }
        return a;
    }

    public int[] sortInt(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }

            }

        }
        return a;
    }

    /**
     * Searches for duplicate items in the array of byte
     *
     * @param bytes array of byte
     * @return true - if array contains duplicate items
     * false - if array does not contain duplicates
     */
    public boolean compareByte(byte[] bytes) {
        boolean[] arr = new boolean[256];

        for (byte i : bytes) {
            if (!arr[i + 128]) {
                arr[i + 128] = true;
            } else {
                return true;
            }
        }
        return false;
    }
}