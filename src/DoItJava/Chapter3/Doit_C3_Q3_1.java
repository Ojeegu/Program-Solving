package DoItJava.Chapter3;

import java.util.Scanner;

public class Doit_C3_Q3_1 { //구간 합 구하기 (Scanner이용)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //수의 개수 입력
        int m = sc.nextInt(); //합을 구해야 하는 횟수 입력
        int[] nArr = new int[n+1]; //인덱스 1~n까지 숫자를 저장하는 배열 생성
        int[] sumArr = new int[n+1]; //구간 합을 저장할 배열 생성
        for(int i = 1; i < n+1; i++) {
            nArr[i] = sc.nextInt(); //n개의 숫자 입력
            sumArr[i] = sumArr[i-1] + nArr[i]; //1~i번째까지 숫자의 누적 합을 저장
        }
        for(int h = 0; h < m; h++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(sumArr[j] - sumArr[i-1]);
        }
    }
}
