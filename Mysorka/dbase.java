
import java.sql.*;
import java.util.ArrayList;
import Jama.Matrix;

public class dbase {
    private static Connection co, co1, coU;
    public PreparedStatement statement;

    public static void main(String[] args) {

        ArrayList<String> pipes = new ArrayList<String>();
        try {
            Class.forName("org.sqlite.JDBC");
            co = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\Admin\\Desktop\\Nir\\NIR\\NIR\\lib\\pipes.db");
            coU = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\Admin\\Desktop\\Nir\\NIR\\NIR\\lib\\pipesU.db");
            co1 = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\Admin\\Desktop\\Nir\\NIR\\NIR\\lib\\pipes1.db");
            PreparedStatement preparedStatement = co.prepareStatement("select * from pipes");
            ResultSet result = preparedStatement.executeQuery();
            PreparedStatement preparedStatementU = coU.prepareStatement("select * from pipesU");
            ResultSet resultU = preparedStatementU.executeQuery();
            PreparedStatement pstmt = co1.prepareStatement("INSERT INTO pipes1 (id, pipes_length, pipes_diameter, pipes_wall_thickness) VALUES (?, ?, ?, ?)");
            ResultSetMetaData rsmd = result.getMetaData();
            ResultSetMetaData rsmdU = resultU.getMetaData();
            int columns = rsmd.getColumnCount();
            int columnsU = rsmdU.getColumnCount();

            ArrayList<String> arr = reader(result, pipes, columns);
            ArrayList<String> arrU = reader(resultU, pipes, columnsU);

            double[][] matrix = listToMatrix(arr, columns);
            double[][] matrixU = listToMatrix(arrU, columnsU);

            Matrix matrixArr = new Matrix(matrix);
            Matrix matrixArrU = new Matrix(matrixU);
            Matrix matrixSum = matrixArr.plus(matrixArrU);

            System.out.println(arr);
            System.out.println(arrU);

            ArrayList<String> arr1 = matrixToList(matrixSum);

            copy(arr1, columns, pstmt);
            System.out.println("хорошая работа, Олег");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static double[][] listToMatrix(ArrayList<String> arr, int columns){ //метод заполняющий матрицу значениями из Аррей листа
        int rows = arr.size();
        int cols = columns;
        double[][] matrix = new double[rows][cols];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String str = arr.get(k);
                double num = Double.parseDouble(str);
                System.out.println(num);
                matrix[i][j] = num;
                k++;
            }
        }
        return matrix;
    }

    public static ArrayList<String> matrixToList(Matrix matrix) {
        ArrayList<String> list = new ArrayList<String>();
        int rows = matrix.getRowDimension();
        int cols = matrix.getColumnDimension();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                list.add(Double.toString(matrix.get(i, j)));
            }
        }
        return list;
    }

    public static ArrayList<String> reader(ResultSet result, ArrayList<String> pipes, int columns) throws SQLException {
        while(result.next()) {
            for(int i = 1; i<columns+1 ; i++) {
                pipes.add(result.getString(i));
            }
        }
        return pipes;
    }

    public static void copy(ArrayList<String> arr, int columns, PreparedStatement pstmt) throws SQLException {
        int k=0;
        for(int j=0; j< arr.size()/columns; j++){

            for(int i = 1; i<columns+1 ; i++) {
                pstmt.setString(i, arr.get(k));
                k++;
            }pstmt.executeUpdate();
        }
    }
}
