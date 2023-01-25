import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] numArr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArr);
		int m = Integer.parseInt(br.readLine());
		int[] findArr = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			findArr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < m; i++) {
			int target = findArr[i];
			int start = 0;
			int end = n - 1;
			boolean flag = false;
			while(start <= end) {
				int mid = (start + end) / 2;
				if(numArr[mid] < target) start = mid + 1;
				else if(numArr[mid] > target) end = mid - 1;
				else {
					flag = true;
					break;
				}
			}
			if(flag) sb.append(1 + "\n");
			else sb.append(0 + "\n");
		}
		System.out.println(sb);
	}
}
