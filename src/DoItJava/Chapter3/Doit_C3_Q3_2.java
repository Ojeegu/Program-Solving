package DoItJava.Chapter3;

import java.io.*;
import java.util.*;

public class Doit_C3_Q3_2 {
    public static void main(String[] args) throws IOException {
        //BufferedReader : Enter를 인식하여 String(문자열)로 받는 객체
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //(1번째줄 입력) : n, m
        StringTokenizer st = new StringTokenizer(br.readLine()); //String(문자열)을 token(공백) 단위로 끊어읽을 수 있는 객체
        //Integer.parseInt(st.nextToken()) : st에 저장된 문자열을 token 단위로 잘라서 정수형으로 변환한 뒤 num 변수에서 저장
        int n = Integer.parseInt(st.nextToken()); //수의 개수
        int m = Integer.parseInt(st.nextToken()); //합을 구해야하는 횟수
        int[] arr = new int[n+1]; // 1~n까지의 인덱스에 수를 저장하기 위해 n+1 크기로 배열 생성
        st = new StringTokenizer(br.readLine()); //(2번째줄 입력) : 구간 합을 구할 대상 배열 값 입력
        for(int i = 1; i < n+1; i++) {
            //arr[1] = arr[0] + st에 저장된 문자열을 공백 기준으로 잘라 정수로 변환한 값
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken()); //합 배열 생성
        }
        for(int a = 0; a < m; a++) { //합을 m번 구하도록 반복문 생성
            st = new StringTokenizer(br.readLine()); //(3번째줄 입력) : 합을 구해야 하는 구간 i, j 입력
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(arr[j] - arr[i-1]); //배열 입력값의 i번째 숫자부터 j번째 숫자까지의 합(= j까지 더한 누적합계에서 i-1번째까지 더한 누적합계를 뺌)
        }
    }
}
