
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //블루레이 만들기
    static int[] arr;
    static int start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //강의 수
        int m = Integer.parseInt(st.nextToken()); //블루레이 수
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); //각 강의 길이
            if(start < arr[i]) start = arr[i]; //가장 긴 강의 길이로 start 설정
            end += arr[i]; //강의 총 길이로 end 설정
        }
        int answer = 0; //출력값 초기화
        while(start <= end) {
            int mid = (start + end) / 2;
            if(blurayNum(mid) <= m) {
                answer = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }
        System.out.println(answer);
    }

    static int blurayNum(int capacity) { //capacity를 기준으로 나눴을 때의 블루레이 수를 return 하는 메서드
        int number = 1; //기본 블루레이 수 1개
        int sum = 0; //강의 길이 누적
        for(int x : arr) {
            if(sum+x <= capacity) {
                sum += x;
            }
            else {
                sum = x;
                number++;
            }
        }
        return number;
    }
}
