import Jama.Matrix;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class jamaMa {
    public static int rows, columns;
    public static void main(String[] args) {
        try {

            String fileName1 = "testJaMa1.txt";
            double[][] data1 = fileToMatrix(fileName1);
            Matrix matrix1 = new Matrix(data1);

            String fileName2 = "testJaMa2.txt";
            double[][] data2 = fileToMatrix(fileName2);
            Matrix matrix2 = new Matrix(data2);

            Matrix matrixSum = matrix1.plus(matrix2);

            matrixSum.print(4, 1); // вывод матрицы в консоль для проверки

            jamaMa obj = new jamaMa();
            obj.matrixToFile(matrixSum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static double[][] fileToMatrix(String fileName) throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader(fileName)); // открытие файла для чтения
            String line = reader.readLine(); // чтение первой строки файла
            String[] size = line.split("\\s+"); // разбиение строки на массив строк, используя пробелы как разделители
            rows = Integer.parseInt(size[0]); // количество строк в матрице
            columns = Integer.parseInt(size[1]); // количество столбцов в матрице
            double[][] data = new double[rows][columns]; // создание двумерного массива для хранения данных из файла
            for (int i = 0; i < rows; i++) { // цикл по строкам матрицы
                line = reader.readLine(); // чтение строки из файла
                String[] elements = line.split("\\s+"); // разбиение строки на массив строк, используя пробелы как разделители
                for (int j = 0; j < columns; j++) { // цикл по столбцам матрицы
                    data[i][j] = Double.parseDouble(elements[j]); // преобразование элемента из строки в тип double и добавление его в матрицу
                }
            }
            reader.close(); // закрытие файла

        return data;
    }

    public static void matrixToFile(Matrix matrixSum) throws IOException{ 

        FileWriter writer = new FileWriter("resultJaMa.txt"); // создание нового файла для записи
        writer.write(rows + " " + columns + "\n"); // запись размерности матрицы в первую строку файла
        for (int i = 0; i < rows; i++) { // цикл по строкам матрицы
            for (int j = 0; j < columns; j++) { // цикл по столбцам матрицы
                writer.write(matrixSum.get(i, j) + " "); // запись элемента матрицы в файл
            }
            writer.write("\n"); // переход на новую строку
        }
        writer.close(); // закрытие файла
    }
}