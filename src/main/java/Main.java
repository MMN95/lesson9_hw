public class Main {

    public static void main(String[] args) {
        String[][] a = new String[][]{{"0", "1", "2", "3"}, {"1", "2", "3", "4"}, {"2", "3", "4", "5"}, {"3", "4", "5", "6"}};
        try {
            try {
                int sumResult = sumArray(a);
                System.out.println("Сумма элементов в массиве равна: " + sumResult);
            } catch (MyArraySizeException e) {
                System.out.println("Ошибка: неверно задан массив");
            }
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка: в ячейке [" + e.i + "][" + e.j + "] лежат неверные данные");
        }
    }

    public static int sumArray(String[][] arr) throws MyArraySizeException,MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr.length != 4 || arr[i].length != 4) {
                    throw new MyArraySizeException();
                } else {
                    try {
                        sum += Integer.parseInt(arr[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j);
                    }
                }
            }
        }
        return sum;
    }
}
