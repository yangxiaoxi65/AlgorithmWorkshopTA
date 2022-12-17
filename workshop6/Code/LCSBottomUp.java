package unit9;

import java.util.*;

/* Dynamic Programming Java implementation of LCS problem */
public class LCSBottomUp {

    public static Set getLCS(int m, int n, int[][] table, String[][] tableLCS, String str1, String str2, Set<String> allLCS) {
        int i, j;
        // Following steps build table[m+1][n+1] in bottom up fashion.
        // value at table[i][j] contains length of LCS of str1[0,i-1] and str2[0,j-1]
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                    tableLCS[i][j] = "";
                }
                else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                    tableLCS[i][j] = tableLCS[i - 1][j - 1].replaceAll(", ", str1.charAt(i-1)+", ") + str1.charAt(i-1);
                }
                else {
                    if (table[i - 1][j] > table[i][j - 1]){
                        table[i][j] = table[i - 1][j];
                        tableLCS[i][j] = tableLCS[i - 1][j];
                    }
                    else if (table[i][j - 1] > table[i - 1][j]){
                        table[i][j] = table[i][j - 1];
                        tableLCS[i][j] = tableLCS[i][j - 1];
                    }
                    else {
                        table[i][j] = table[i - 1][j];
                        tableLCS[i][j] = tableLCS[i - 1][j] + ", " + tableLCS[i][j - 1];
                    }

                }
            }
        }

        String[] LCS = tableLCS[m][n].split(", ");

        for (int k = 0; k < LCS.length; k++){
            allLCS.add(LCS[k]);
        }
        return allLCS;
    }


    public static void LCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        // matrix to store value of each subproblem
        int[][] table = new int[m+1][n+1];
        String[][] tableLCS = new String[m+1][n+1];
        Set<String> allLCS = new HashSet<String>();

        getLCS(m, n, table, tableLCS, str1, str2, allLCS);
        // table[m][n] contains length of LCS for str1[0,n-1] and str2[0,m-1]
        System.out.println("Length of the LCS: "+ table[m][n]);
        System.out.println("All of the LCS: ");
        System.out.println(allLCS);
    }

    // main function to implement above functions
    public static void main(String args[]) {
        String str1 = "abcabcaa";
        String str2 = "acbacba";
//        long startTime = System.nanoTime();
        LCS(str1, str2);
//        long endTime = System.nanoTime();
//        System.out.println(endTime-startTime);
    }
}
