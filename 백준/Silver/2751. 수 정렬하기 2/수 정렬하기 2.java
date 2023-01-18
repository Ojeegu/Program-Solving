import java.io.*;

public class Main { //수 정렬하기2
    static int[] arr, tmp;
    public void mergeSort(int start, int end) { //머지소트(정렬) 메서드
        if(end - start < 1) return;
        int mid = start + (end - start) / 2; // (start+end)/2로 해도 되지만 overflow 방지차원으로 이렇게 씀
        mergeSort(start, mid); //배열의 오른쪽 부분 재귀함수
        mergeSort(mid + 1, end); //배열의 왼쪽 부분 재귀함수

        for(int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }

        int part1 = start; //tmp배열의 오른쪽 부분의 첫 인덱스
        int part2 = mid + 1; //tmp배열의 왼쪽 부분의 첫 인덱스
        int index = start; //arr배열에 tmp 값을 넣을 위치 변수

        while(part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1]; //part1과 part2 중 더 작은 값을 arr에 저장
                part1++; //tmp 배열의 오른쪽 부분 인덱스를 한칸 옮김
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++; //어떤 값이 들어갔든 arr배열에 값이 저장되었으므로 인덱스 한칸 옮김
        }
        while(part1 <= mid) {
            arr[index] = tmp[part1];
            index++;
            part1++;
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n]; //입력값 저장할 배열 선언
        tmp = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()); //arr 배열에 n개 입력값 저장
        }

        main.mergeSort(0, n-1);
        for(int x : arr) {
            bw.write(x + "\n");
        }
        bw.flush();
        bw.close();
    }
}
