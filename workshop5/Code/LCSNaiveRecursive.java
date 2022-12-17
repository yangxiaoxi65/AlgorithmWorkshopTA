package unit9;

public class LCSNaiveRecursive {
    public static int LCS(String str1,String str2,int m,int n) {
        // if length of any string is 0, return 0
        if(n == 0 || m == 0) {
            return 0;
        }
        // if last characters match, remove them
        // then find LCS of remaining strings
        if(str1.charAt(m-1) == str2.charAt(n-1)) {
            return 1 + LCS(str1, str2, m - 1, n - 1);
        }
        // if last characters don't match alternately remove last character of each string to find LCS
        return Math.max(LCS(str1,str2,m-1,n),LCS(str1,str2,m,n-1));
    }

    public static void main(String args[]) {
        String str1 = "AGCA";
        String str2 = "GAC";

        int m = str1.length();
        int n = str2.length();
        long startTime = System.nanoTime();
        System.out.println("Length of LCS : "+LCS(str1,str2,m,n));
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
    }
}
