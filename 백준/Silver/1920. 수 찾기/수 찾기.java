import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //수 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); //정수 개수 입력
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); //n개의 정수를 배열에 저장
        }
        Arrays.sort(arr); //arr배열을 오름차순 정렬
        int m = Integer.parseInt(br.readLine()); //찾을 정수 개수 입력
        int[] findArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            findArr[i] = Integer.parseInt(st.nextToken()); //m개의 정수를 배열에 저장
        }
        for(int i = 0; i < m; i++) { //arr 배열에 찾는 정수가 있는지 없는지 확인
            boolean flag = false;
            int target = findArr[i]; //찾아야 하는 수
            int start = 0;
            int end = n-1;
            while(start <= end) {
                int mid = (start + end) / 2;
                if(arr[mid] < target) {
                    start = mid + 1;
                }
                else if(arr[mid] > target) {
                    end = mid - 1;
                }
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
