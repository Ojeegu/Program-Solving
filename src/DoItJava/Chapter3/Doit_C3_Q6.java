package DoItJava.Chapter3;

import java.util.Scanner;

public class Doit_C3_Q6 { //연속된 자연수의 합 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //자연수 입력
        int startIndex = 1, endIndex = 1; //시작 포인터와 끝 포인터 모두 1로 초기화
        int sum = 1; //startIndex ~ endIndex까지 더한 값을 저장하는 변수
        int count = 1; //자기 자신(n)도 연속된 합이므로 1로 초기화
        while(endIndex < n) {
            if(sum < n) {
                endIndex++;
                sum += endIndex;
            }
            else if(sum == n) {
                count++;
                endIndex++;
                sum += endIndex;
            }
            else {
                sum -= startIndex;
                startIndex++;
            }
        }
        System.out.println(count);
    }
}
