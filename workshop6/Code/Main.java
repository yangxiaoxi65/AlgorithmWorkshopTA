package unit9;
import java.util.HashMap;
public class Main {
	public static void main(String[] args) {
		int N = 500;

		for (int n = 10; n <= N; n += 10) {
			long LCSBruteForceTime = 0;
			long LCSNaiveRecursiveTime = 0;
			long LCSTopDownTime = 0;
			long LCSBottomUpTime = 0;
			String str1 = "";
			String str2 = "";
			for (int j = 0; j < n; j++) {
				str1 += (char)(Math.random()*26+'a');
				str2 += (char)(Math.random()*26+'a');
			}
//			System.out.println(str1);
//			System.out.println(str2);

			for (int i = 0; i < 50; i++) {
				int m = str1.length();
				int l = str2.length();
				HashMap<String,Integer> memo = new HashMap <String,Integer>();
				long startTime = System.nanoTime();
//				unit9.LCSBruteForce.getLCS(str1, str2);
//				unit9.LCSNaiveRecursive.LCS(str1, str2, m, l);
				unit9.LCSTopDown.LCS(str1, str2);
//				unit9.LCSBottomUp.LCS(str1,str2);
				long endTime = System.nanoTime();
//				LCSBruteForceTime += (endTime-startTime);
//				System.out.println(LCSBruteForceTime);
//				LCSNaiveRecursiveTime += (endTime-startTime);
//				System.out.println(LCSNaiveRecursiveTime);
				LCSTopDownTime += (endTime-startTime);
//				System.out.println(LCSTopDownTime);
//				LCSBottomUpTime += (endTime-startTime);
			}
//			System.out.println(LCSBruteForceTime/10);
//			System.out.println(LCSNaiveRecursiveTime/10);
			System.out.println(LCSTopDownTime/50);
//			System.out.println(LCSBottomUpTime/50);
		}
	}
}