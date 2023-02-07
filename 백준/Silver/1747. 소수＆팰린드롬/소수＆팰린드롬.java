import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while(true) {
			if(isPrime(n) && isPalindrome(String.valueOf(n))) {
				System.out.println(n);
				break;
			}
			n++;
		}
	}
	static boolean isPrime(int num) {
		if(num < 2) return false;
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
	static boolean isPalindrome(String num) {
		int start = 0;
		int end = num.length() - 1;
		while(start <= end) {
			if(num.charAt(start) != num.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}
}
