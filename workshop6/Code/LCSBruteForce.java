package unit9;

public class LCSBruteForce {
		// see if the (i-1)-th digit of the int m is 1
        public static boolean isOne(int m, int i) { 
            i = i - 1;
            int k = m & (1 << i);
            return k > 0;
        }
        // construct a substring of x by m
        public static String getSubString(String x, String y, int m) {
            String s = "";
            int len = x.length();
            for (int i = 1; i <= len; i++) {
            	// see if the (i-1)-th digit of m is 1
                if (isOne(m, i)) { 
                    s = x.charAt(len - i) + s;
                }
            }
            return s;
        }

        public static String getLCS(String x, String y) {
            int len = x.length();
            int m = (1 << len) - 1;
            int maxLen = 0;
            String longest = null;
            for (int i = m; i > 0; i--) {
                // each m represents a sequence of substrings in x
                String sub = getSubString(x, y, i);
                boolean isSeq = isSubSeq(x,y,sub);
                if (isSeq) {
                    if (sub.length() > maxLen) {
                        longest = sub;
                        maxLen = sub.length();
                    }
                }
            }
            return longest;
        }

        public static boolean isSubSeq(String x, String y, String sub) {
            int si = 0;
            for (int i = 0; i < y.length(); i++) {
                if (sub.charAt(si) == y.charAt(i)) {
                    si++;
                    if (si == sub.length()) {
                        return true;
                    }
                }
            }
            return false;
        }

        public static void main(String[] args) {
            //String y = "ABCBDAB";
            String x = "13456778";
            //String x = "BDCABA";
            String y = "357486782";
            long startTime = System.nanoTime();
            String result = getLCS(x,y);
//          System.out.println(result);
            long endTime = System.nanoTime();
            System.out.println(endTime-startTime);
        }

}
