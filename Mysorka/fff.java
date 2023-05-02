
import Jama.Matrix;

public class fff {
    public static void main(String[] args) {
        // Создание матрицы размерности 4 на 4
        double[][] matrixArray = new double[][]{
            {4.0, 2.0, 3.0, 2.0},
            {9.0, 6.0, 7.0, 8.0},
            {9.0, 10.0, 1.0, 12.0},
            {13.0, 8.0, 11.0, 18.0}
        };
        Matrix matrix = new Matrix(matrixArray);

        // Базовые операции над матрицей
        Matrix matrixTranspose = matrix.transpose(); // Транспонирование матрицы
        Matrix matrixProduct = matrix.times(matrixTranspose); // Умножение матрицы на ее транспонированную
        Matrix matrixSum = matrix.plus(matrixTranspose); // Сложение матрицы на ее транспонированную
        Matrix matrixSubtract = matrix.minus(matrixTranspose); // Вычитание матрицы из ее транспонированной
        Matrix matrixInverse = matrix.inverse(); // Обратная матрица

        // Вывод результатов
        System.out.println("Исходная матрица:");
        for (int i = 0; i < matrix.getRowDimension(); i++) {
            for (int j = 0; j < matrix.getColumnDimension(); j++) {
                System.out.print(matrix.get(i, j) + " ");
            }
            System.out.println();
        }

        System.out.println("Транспонированная матрица:");
        for (int i = 0; i < matrixTranspose.getRowDimension(); i++) {
            for (int j = 0; j < matrixTranspose.getColumnDimension(); j++) {
                System.out.print(matrixTranspose.get(i, j) + " ");
            }
            System.out.println();
        }

        System.out.println("Произведение матрицы на ее транспонированную:");
        for (int i = 0; i < matrixProduct.getRowDimension(); i++) {
            for (int j = 0; j < matrixProduct.getColumnDimension(); j++) {
                System.out.print(matrixProduct.get(i, j) + " ");
            }
            System.out.println();
        }

        System.out.println("Сумма матрицы и ее транспонированную:");
        for (int i = 0; i < matrixSum.getRowDimension(); i++) {
            for (int j = 0; j < matrixSum.getColumnDimension(); j++) {
                System.out.print(matrixSum.get(i, j) + " ");
            }
            System.out.println();
        }

        System.out.println("Разность матрицы и ее транспонированной:");
        for (int i = 0; i < matrixSubtract.getRowDimension(); i++) {
            for (int j = 0; j < matrixSubtract.getColumnDimension(); j++) {
                System.out.print(matrixSubtract.get(i, j) + " ");
            }
            System.out.println();
        }

        System.out.println("Обратная матрица:");
        for (int i = 0; i < matrixInverse.getRowDimension(); i++) {
            for (int j = 0; j < matrixInverse.getColumnDimension(); j++) {
                System.out.print(matrixInverse.get(i, j) + " ");
            }
            System.out.println();
        }

    }
}


