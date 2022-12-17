package unit9;
import java.util.HashMap;
public class LCSTopDown {
    public static int LCS(String str1,String str2,int m,int n, HashMap <String,Integer> memo) {
        // return if we have reached the end of either string
        if (n == 0 || m == 0)
            return 0;
        // construct an unique map key from dynamic elements of the input
        String key = m + "|" + n;
        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!memo.containsKey(key)) {
            // if last character of str1 and str2 matches
            if (str1.charAt(m-1) == str2.charAt(n-1)) {
                memo.put(key, 1 + LCS(str1, str2, m - 1, n - 1, memo));
            }
            else {
                // else if last character of str1 and str2 don't match
                memo.put(key, Math.max(LCS(str1, str2, m, n - 1, memo), LCS(str1, str2, m - 1, n, memo)));
            }
        }
        // return the subproblem solution from the map
        return memo.get(key);
    }
    public static void main(String[] args) {
        String str1 = "AGCA";
        String str2 = "GAC";
        // we use map to store memoized values
        HashMap <String,Integer> memo = new HashMap <String,Integer>();

        int m = str1.length();
        int n = str2.length();

        long startTime = System.nanoTime();
        System.out.println("Length of LCS : "+LCS(str1,str2,m,n,memo));
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
    }
}
