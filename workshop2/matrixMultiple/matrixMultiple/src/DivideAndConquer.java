public class DivideAndConquer {
    public static int[][] divideAndConquer(int[][] a, int[][] b,int n) {
        int[][] result = new int[n][n];
        if(n==2){
            return BruteForce.bruteForce(a,b,n);
        }
        if(n>2){
            int m=n/2;
            int[][] p1=quarterMatrix(a,n,1);
            int[][] p2=quarterMatrix(a,n,2);
            int[][] p3=quarterMatrix(a,n,3);
            int[][] p4=quarterMatrix(a,n,4);

            int[][] q1=quarterMatrix(b,n,1);
            int[][] q2=quarterMatrix(b,n,2);
            int[][] q3=quarterMatrix(b,n,3);
            int[][] q4=quarterMatrix(b,n,4);

            int[][] result1 = quarterMatrix(result,n,1);
            int[][] result2 = quarterMatrix(result,n,2);
            int[][] result3 = quarterMatrix(result,n,3);
            int[][] result4 = quarterMatrix(result,n,4);


            result1 = addMatrix(divideAndConquer(p1,q1,m),divideAndConquer(p2,q3,m),m);
            result2 = addMatrix(divideAndConquer(p1,q2,m),divideAndConquer(p2,q4,m),m);
            result3 = addMatrix(divideAndConquer(p3,q1,m),divideAndConquer(p4,q3,m),m);
            result4 = addMatrix(divideAndConquer(p3,q2,m),divideAndConquer(p4,q4,m),m);


            result = togetherMatrix(result1,result2,result3,result4,m);
        }
        return result;
    }

    //获取矩阵的四分之一，并决定返回哪一个四分之一
    public static int[][] quarterMatrix(int[][] a,int n,int number){
        int row=n/2,col=n/2;
        int[][] result = new int[row][col];
        switch(number){
            case 1:
                for(int i=0;i<row;i++){
                    for(int j=0;j<col;j++){
                        result[i][j]=a[i][j];
                    }
                }
                break;
            case 2:
                for(int i=0;i<row;i++){
                    for(int j=0;j<n-col;j++){
                        result[i][j]=a[i][j+col];
                    }
                }
                break;

            case 3 :
            {

                for(int i=0;i<n-row;i++){
                    for(int j=0;j<col;j++){
                        result[i][j] = a[i+row][j];
                    }
                }
                break;
            }
            case 4 :
            {
                for(int i=0;i<n-row;i++){
                    for(int j=0;j<n-col;j++){
                        result[i][j] = a[i+row][j+col];
                    }
                }
                break;
            }

            default:
                break;
        }
        return result;
    }

    //把均分为四分之一的矩阵，聚合成一个矩阵，其中矩阵a,b,c,d分别对应原完整矩阵的四分中1、2、3、4
    public static int[][] togetherMatrix(int[][] a,int[][] b,int[][] c,int[][] d,int n){
        int[][] result = new int[2*n][2*n];
        for(int i=0;i<2*n;i++){
            for(int j=0;j<2*n;j++){
                if(i<n){
                    if(j<n){
                        result[i][j] = a[i][j];
                    }
                    else
                        result[i][j] = b[i][j-n];
                }
                else{
                    if(j<n){
                        result[i][j] = c[i-n][j];
                    }
                    else{
                        result[i][j] = d[i-n][j-n];
                    }
                }
            }
        }

        return result;
    }

    //求两个矩阵相加结果
    public static int[][] addMatrix(int[][] p,int[][] q,int n){
        int[][] result = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[i][j] = p[i][j]+q[i][j];
            }
        }
        return result;
    }
}
