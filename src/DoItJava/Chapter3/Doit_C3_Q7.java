package DoItJava.Chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Doit_C3_Q7 { //주몽
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //재료 수 입력
        int m = Integer.parseInt(br.readLine()); //갑옷의 고유 번호 입력
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()); //갑옷 각각의 고유 번호 입력
        for(int i = 0; i < n; i++) { // arr배열에 갑옷의 고유 번호 저장
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //arr배열을 오름차순으로 정렬
        int start = 0; //arr[start] = arr[0]
        int end = n-1; //arr[n-1] = arr 배열의 마지막 인덱스
        int count = 0; //재료 두 개로 갑옷을 만들 수 있는 경우의 수
        while(start < end) {
            if(arr[start] + arr[end] < m) start++;
            else if(arr[start] + arr[end] > m) end--;
            else {
                count++;
                start++;
                end--;
            }
        }
        System.out.println(count);
    }
}
