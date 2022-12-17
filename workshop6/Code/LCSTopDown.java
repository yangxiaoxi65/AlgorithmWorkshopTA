package unit9;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LCSTopDown {
    public static String getLCS(String str1,String str2,int m,int n, HashMap <String,String> memoLCS) {
        // return if we have reached the end of either string
        if (n == 0 || m == 0) {
            return "";
        }
        // construct an unique map key from dynamic elements of the input
        String key = m + "|" + n;
        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!memoLCS.containsKey(key)) {
            // if last character of str1 and str2 matches
            if (str1.charAt(m-1) == str2.charAt(n-1)) {
                memoLCS.put(key, getLCS(str1, str2, m - 1, n - 1, memoLCS).replaceAll(", ", str1.charAt(m-1)+", ") + str1.charAt(m-1));

            }
            // else if last characters of str1 and str2 don't match
            else {
                String[] LCS1 = getLCS(str1, str2, m, n - 1, memoLCS).split(", ");
                String[] LCS2 = getLCS(str1, str2, m - 1, n, memoLCS).split(", ");
                if (LCS1[0].length() > LCS2[0].length()){
                    memoLCS.put(key, getLCS(str1, str2, m, n - 1, memoLCS));
                }
                else if (LCS2[0].length() > LCS1[0].length()){
                    memoLCS.put(key, getLCS(str1, str2, m - 1, n, memoLCS));
                }
                else {
                    memoLCS.put(key, getLCS(str1, str2, m, n - 1, memoLCS) + ", " + getLCS(str1, str2, m - 1, n, memoLCS));
                }
            }

        }
        // return the subproblem solution from the map
        return memoLCS.get(key);
    }

    public static void LCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // we use map to store memoized values
        HashMap <String,String> memoLCS = new HashMap <String,String>();
        Set<String> allLCS = new HashSet<String>();

        getLCS(str1,str2, m, n, memoLCS);
        String[] LCS =  getLCS(str1,str2, m, n, memoLCS).split(", ");
        for (int k = 0; k < LCS.length; k++){
            allLCS.add(LCS[k]);

        }
        System.out.println("Length of LCS : " + LCS[1].length());
        System.out.println("All of the LCS: ");
        System.out.println(allLCS);
    }

    public static void main(String[] args) {
//        String str1 = "AGCA";
//        String str2 = "GAC";
        String str1 = "abcabcaa";
        String str2 = "acbacba";

//        long startTime = System.nanoTime();
        LCS(str1, str2);
//        long endTime = System.nanoTime();
//        System.out.println(endTime-startTime);
    }
}

