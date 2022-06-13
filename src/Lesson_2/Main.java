package Lesson_2;


public class Main {

    static String[][] arrayDataException = {{"1", "2", "3", "4"}, {"7", "6", "7", "8"}, {"9", "р", "7", "8"}, {"5", "6", "7", "8"}};

    static String[][] arraySizeException = {{"1", "2"}, {"1", "6",}, {"9", "6"}, {"5", "6"}};

    static String[][] arrayWithNoError = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "6", "7", "8"}, {"5", "6", "7", "8"}};

    static int sizeA = 4;
    static int sizeB = 4;

    public static void main(String[] args) {

        try {
            System.out.println("Сумма элементов массива: " + summElements(arrayWithNoError));
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Сумма элементов массива: " + summElements(arraySizeException));
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Сумма элементов массива: " + summElements(arrayDataException));
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void checkValue(String[][] array) throws MyArraySizeException {
        if (array.length != sizeA || array[0].length != sizeB) throw new MyArraySizeException();
    }

    static int summElements(String[][] array) throws MyArrayDataException, MyArraySizeException {
        checkValue(array);
        int result = 0;
        int i = 0;
        int j = 0;
        try {
            for (; i < array.length; i++) {
                j = 0;
                for (; j < array.length; j++) {
                    result = result + Integer.parseInt(array[i][j]);
                }
            }
        } catch (NumberFormatException ex) {
            throw new MyArrayDataException("Ошибка в позиции: " + i + "," + j);
        }

        return result;
    }
}