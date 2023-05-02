import Jama.Matrix;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class jamaMa {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("testJaMa.txt"));
            String line = reader.readLine();
            String[] size = line.split("\\s+");

            int rows = Integer.parseInt(size[0]);
            int columns = Integer.parseInt(size[1]);

            double[][] data = new double[rows][columns];

            for (int i = 0; i < rows; i++) {
                line = reader.readLine();
                String[] elements = line.split("\\s+");
                for (int j = 0; j < columns; j++) {
                    data[i][j] = Double.parseDouble(elements[j]);
                }
            }

            reader.close();

            Matrix matrix = new Matrix(data);
            Matrix multipliedMatrix = matrix.times(2); // умножение матрицы на 2

            // вывод матрицы для проверки
            multipliedMatrix.print(4, 2);

            // создание нового файла и запись в него умноженной матрицы
            FileWriter writer = new FileWriter("resultJaMa.txt");
            writer.write(rows + " " + columns + "\n");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    writer.write(multipliedMatrix.get(i, j) + " ");
                }
                writer.write("\n");
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}