package DoItJava.Chapter3;

import java.util.Scanner;

public class Doit_C3_Q5 { //나머지 합 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long answer = 0;
        int n = sc.nextInt(); //수열의 개수 입력
        int m = sc.nextInt(); //나누어 떨어져야 하는 수 입력
        long[] sumArr = new long[n+1]; //구간 합을 저장 할 배열 생성(인덱스 1~n까지 사용)
        long[] cntArr = new long[m]; //나머지가 같은 수의 인덱스를 카운트하는 배열 생성
        for(int i = 1; i < n+1; i++) {
            sumArr[i] = sumArr[i-1] + sc.nextInt(); //입력받은 수열을 합 배열로 계산하여 저장
        }
        for(int i = 1; i < n+1; i++) { //0~i까지 부분합 중 m으로 나누어 떨어지는 수가 있는지 파악하고 카운트
            int remainder = (int)(sumArr[i] % m); //sumArr의 i번째 수를 m으로 나누었을 때 그 나머지를 remainder 변수에 저장
            if(remainder == 0) answer++; //m으로 나눈 나머지가 0이면 조건을 만족하므로 카운트 누적
            cntArr[remainder]++; //나머지가 0이 아닌 다른 수라면 cntArr 배열의 해당 인덱스에 카운트 누적(나머지가 같은 경우가 몇 가지인지 파악하기 위함)
        }
        for(int i = 0; i < m; i++) {// i~j까지 부분합 중 m으로 나누어 떨어지는 수가 있는지 파악
            //S[j] % m = S[i-1] % m 공식을 사용하여 나머지가 i인 인덱스의 개수(cntArr)에서 2가지를 뽑는 경우의 수를 카운트
            if(cntArr[i] > 1) answer += (cntArr[i] * (cntArr[i] - 1) / 2); //cntArr의 i번째 값 : 나머지가 i인 인덱스의 수(따라서 2 미만은 필요x)
        }
        System.out.println(answer);
    }
}
