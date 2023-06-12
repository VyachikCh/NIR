import Jama.Matrix;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class jamaMatrixSistem {
    public static void main(String[] args) {
        
        jamaMatrixSistem.solveSistem("A.txt", "B.txt", "X.txt");
    }

    public static void solveSistem(String fileNameA, String fileNameB, String fileNameX){ 
        try {

            BufferedReader readerA = new BufferedReader(new FileReader(fileNameA));
            BufferedReader readerB = new BufferedReader(new FileReader(fileNameB));
            Matrix A = Matrix.read(readerA);
            Matrix B = Matrix.read(readerB);
            Matrix X = A.solve(B);

            jamaMatrixSistem.matrixToFile(X, fileNameX);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void matrixToFile(Matrix M, String fileName) throws IOException{ 

        FileWriter writer = new FileWriter(fileName); // создание нового файла для записи
        int rows = M.getRowDimension();
        int columns = M.getColumnDimension();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                writer.write(M.get(i, j) + " "); // запись элемента матрицы в файл
            }
            writer.write("\n"); // переход на новую строку
        }
        writer.close(); // закрытие файла
    }
}