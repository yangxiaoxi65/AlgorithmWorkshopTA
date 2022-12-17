public class Main {
    public static void main(String[] args) {
        for (int i = 2; i<= 11; i++){
            long startTime = 0;
            long endTime = 0;
            int num = (int) Math.pow(2, i);
            int size = num;
            int[][] ma = MatrixUtil.generateMatrix(num);
            int[][] mb = MatrixUtil.generateMatrix(num);
            //        System.out.println("Original MatrixA: ");
            //        MatrixUtil.displayMatrix(ma);
            //        System.out.println("Original MatrixB: ");
            //        MatrixUtil.displayMatrix(mb);
            startTime = System.nanoTime();
//            int[][] result1 = BruteForce.bruteForce(ma, mb, size);
            int[][] result2 = DivideAndConquer.divideAndConquer(ma,mb,size);
            endTime = System.nanoTime();
            //        System.out.println("Result of compute between two matrices: ");

            System.out.println(num+": "+ (endTime-startTime));
        }
//        MatrixUtil.displayMatrix(hikari);
    }
}
