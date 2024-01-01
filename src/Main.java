import java.util.Random;

public class Main {

    public static void arraySizeCheck(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int[][] newArray = new int[array[0].length][array[1].length];
        if (array[0].length > 4 || array[1].length > 4) {
            throw new MyArraySizeException("Размер массива больше 4");
        }

        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array[1].length; j++) {
                try {
                    newArray[i][j] = Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке [" + i + "][" + j + "] содержится " + array[i][j] + " вместо числа");
                }

            }
        }

        for (int i = 0; i < newArray[0].length; i++) {
            for (int j = 0; j < newArray[1].length; j++) {
                System.out.print(newArray[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        String[][] myArray = new String[4][4];
        Random random = new Random();
        for (int i = 0; i < myArray[0].length; i++) {
            for (int j = 0; j < myArray[1].length; j++) {
                myArray[i][j] = Integer.toString(random.nextInt(5));
            }
        }
        myArray[2][1] = "sfdsfs";
        try {
            arraySizeCheck(myArray);
        } catch (MyArraySizeException e) {
            System.out.printf("Ошибка при проверке размера массива\n%s", e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.printf("Ошибка при попытке конвертации массива\n%s", e.getMessage());
        }
    }
}