import java.io.*;

public class Main {

    static int[] arr, tmp; //시간 감소를 위해 arr, tmp 배열을 static으로 선언

    public void mergeSort(int start, int end) { //머지소트(정렬) 메서드
        if (start < end) {
            // '(start+end)/2'로 해도 되지만 overflow 방지 차원으로 피연산자 값을 먼저 감소시킴
            int mid = start + (end - start) / 2; //배열의 중앙 인덱스
            mergeSort(start, mid); //mid 기준 오른쪽 부분 재귀함수
            mergeSort(mid + 1, end); //mid 기준 왼쪽 부분 재귀함수
            merge(start, mid, end); //정복 메서드 호출
        }
    }

    public void merge(int start, int mid, int end) {
        for (int i = start; i <= end; i++) { //arr배열 값을 tmp배열로 복사
            tmp[i] = arr[i];
        }

        int part1 = start; //tmp배열의 왼쪽 부분의 첫 인덱스
        int part2 = mid + 1; //tmp배열의 오른쪽 부분의 첫 인덱스
        int index = start; //arr배열에 tmp 값을 넣을 위치 인덱스

        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1]; //part1과 part2 중 더 작은 값을 arr에 저장
                part1++; //tmp 배열의 왼쪽 부분 인덱스를 한칸 옮김
            } else {
                arr[index] = tmp[part2];
                part2++; //tmp 배열의 오른쪽 부분 인덱스를 한칸 옮김
            }
            index++; //어떤 값이 들어갔든 arr배열에 값이 저장되었으므로 arr의 인덱스를 한칸 옮김
        }
			/*
            part1(왼쪽)에 정렬할 항목이 아직 남았는데 while문이 끝난 경우
            (=part2(오른쪽) 정렬이 먼저 끝난 경우)
            tmp배열의 남은 값들을 arr에 저장
            */
        while (part1 <= mid) {
            arr[index] = tmp[part1];
            index++;
            part1++;
        }
            /*
            part2(왼쪽)에 정렬할 항목이 남은 경우(=part1(오른쪽) 정렬이 먼저 끝난 경우)
            arr 배열의 뒷부분은 이미 정렬이 완료되었으므로 굳이 while문을 돌릴 필요가 없음
            */
    }



    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n]; //입력값 저장할 배열 선언
        tmp = new int[n]; //arr을 복사할 배열 선언
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