

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //ATM 인출 시간 계산하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); //사람 수 입력
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine()); //사람이 각각 돈 인출하는데 필요한 시간 입력
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //arr정렬 오름차순

        int total = 0; //모든 사람 걸리는 시간 (합계)
        int per = 0; //사람 당 걸리는 시간
        for(int i = 0; i < n; i++){
            total += per + arr[i];
            per += arr[i];
        }
        System.out.println(total);
    }
}
