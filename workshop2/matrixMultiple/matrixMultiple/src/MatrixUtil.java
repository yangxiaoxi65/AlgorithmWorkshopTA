import java.util.Random;

public class MatrixUtil {
    //n is size about matrix
    public static int[][] generateMatrix(int n){
        int[][] matrix = new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                //range from (-20)----(50)
                matrix[i][j]=(int)new Random().nextInt(11)+(-5);
            }
        }
        return matrix;
    }

//    public static void displayMatrix(int[][] matrix){
//        for (int i=0;i<matrix.length;i++){
//            for (int j=0;j<matrix.length;j++){
//                System.out.print(matrix[i][j]+"\t");
//            }
//            System.out.println("\n");
//        }
//    }
}
