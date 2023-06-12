import Jama.Matrix;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class jamaMatrixSistema {
    public static void main(String[] args) {
        try {

            BufferedReader readerA = new BufferedReader(new FileReader("A.txt"));
            BufferedReader readerB = new BufferedReader(new FileReader("B.txt"));

            Matrix A = Matrix.read(readerA);
            Matrix B = Matrix.read(readerB);

            A.print(4, 1); // вывод матрицы в консоль для проверки
            B.print(4, 1); // вывод матрицы в консоль для проверки

            Matrix X = A.solve(B);

            System.out.println("Решение x:");
            X.print(4, 1); // вывод матрицы в консоль для проверки

            jamaMatrixSistema obj = new jamaMatrixSistema();
            obj.matrixToFile(X);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void matrixToFile(Matrix X) throws IOException{ 

        FileWriter writer = new FileWriter("X.txt"); // создание нового файла для записи
        int rows = X.getRowDimension();
        int columns = X.getColumnDimension();
        for (int i = 0; i < rows; i++) { // цикл по строкам матрицы
            for (int j = 0; j < columns; j++) { // цикл по столбцам матрицы
                writer.write(X.get(i, j) + " "); // запись элемента матрицы в файл
            }
            writer.write("\n"); // переход на новую строку
        }
        writer.close(); // закрытие файла
    }
}