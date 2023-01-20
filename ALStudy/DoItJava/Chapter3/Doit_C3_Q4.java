package DoItJava.Chapter3;

import java.io.*;
import java.util.*;

public class Doit_C3_Q4 { //구간 합 구하기2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); //첫번째 줄 입력 (n, m)
        int n = Integer.parseInt(st.nextToken()); //2차원 배열의 크기
        int m = Integer.parseInt(st.nextToken()); //합을 구해야하는 횟수
        int[][] arr = new int[n+1][n+1]; //인덱스를 1~n까지 활용하기 위해 n+1 크기 배열 생성
        for(int i = 1; i < n+1; i++) { //입력값 받아서 arr 배열 채우기
            st = new StringTokenizer(br.readLine()); //두번째 줄 입력 (arr 배열의 i번째 줄 숫자 입력)
            for(int j = 1; j < n+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); // i번째 줄에 입력된 숫자를 공백 기준으로 잘라 배열에 저장
            }
        }
        int[][] dSum = new int[n+1][n+1]; //구간 합을 저장할 2차원 배열 생성
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                dSum[i][j] = dSum[i-1][j] + dSum[i][j-1] - dSum[i-1][j-1] + arr[i][j];
            }
        }
        for(int i = 0; i < m; i++) { //합을 구해야하는 구간 입력
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int answer = dSum[x2][y2] - dSum[x1-1][y2] - dSum[x2][y1-1] + dSum[x1-1][y1-1];
            System.out.println(answer);
        }
    }
}
