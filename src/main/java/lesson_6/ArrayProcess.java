package lesson_6;

public class ArrayProcess {
    public static int calculateElementSum(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;

        if (arr.length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null || arr[i].length != 4) {
                throw new MyArraySizeException();
            }

            for (int j = 0; j < arr[i].length; j++) {
                try {
                    int z = Integer.parseInt(arr[i][j]);
                    sum += z;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return sum;
    }
}