import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //버블 소트 프로그램2
    static long[] arr, tmp;
    static long result;

    public void mergeSort(int start, int end) {
        if(start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, end, mid);
        }
    }

    public void merge(int start, int end, int mid) {
        for(int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start; //tmp 배열의 왼쪽 부분 첫번째 인덱스
        int part2 = mid + 1; //tmp 배열의 오른쪽 부분 첫번째 인덱스
        int index = start; //arr 배열에 값을 넣을 위치 인덱스
        while(part1 <= mid && part2 <= end) {
            if(tmp[part1] > tmp[part2]) {
                arr[index] = tmp[part2];
                result += part2 - index;
                part2++;
            }
            else {
                arr[index] = tmp[part1];
                part1++;
            }
            index++;
        }
        while(part1 <= mid) {
            arr[index] = tmp[part1];
            index++;
            part1++;
        }
    }

    public static void main(String[] args) throws IOException {
        Main q21 = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 자연수 n개
        arr = new long[n];
        tmp = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) { //arr에 수열값 입력
            arr[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        q21.mergeSort(0, n-1);
        System.out.println(result);
    }
}
