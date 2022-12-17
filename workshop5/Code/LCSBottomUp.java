package unit9;
/* Dynamic Programming Java implementation of LCS problem */
public class LCSBottomUp {
    public static int LCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // matrix to store value of each subproblem
        int[][] table = new int[m+1][n+1];
        int i, j;

        // Following steps build table[m+1][n+1] in bottom up fashion.
        // value at table[i][j] contains length of LCS of str1[0,i-1] and str2[0,j-1]
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                }
                else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                }
                else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        // table[m][n] contains length of LCS for str1[0,n-1] and str2[0,m-1]
        return table[m][n];
    }

    // main function to implement above functions
    public static void main(String args[]) {
        String str1 = "AGCA";
        String str2 = "GAC";
        long startTime = System.nanoTime();
        System.out.println("Length of LCS : "+LCS(str1,str2));
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
    }
}
