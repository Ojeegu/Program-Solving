import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //동전 0
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전 종류
        int k = Integer.parseInt(st.nextToken()); // 만들고 싶은 금액
        int[] arr = new int[n];
        for(int i = 0; i <  n; i++) { //동전 종류 입력 받아서 배열에 저장
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i = n-1; i >= 0; i--) {
            if(k != 0) {
                count += k / arr[i];
                k = k % arr[i];
            }
            else break;
        }
        System.out.println(count);
    }
}