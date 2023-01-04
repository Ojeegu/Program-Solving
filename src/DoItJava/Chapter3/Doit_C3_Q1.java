package DoItJava.Chapter3;

import java.util.Scanner;

public class Doit_C3_Q1 { //숫자의 합 구하기
    public int solution(String str) {
        int answer = 0;
        char[] num = str.toCharArray(); //String 문자열을 char 배열로 변환
        for(char x : num) {
            answer += x - '0'; //현재 x에 문자형 숫자가 저장되어 있으므로 정수형으로 바꿔주어야 함 : (x - '0') or (x - 48)
        }
        return answer;
    }

    public static void main(String[] args) {
        Doit_C3_Q1 q1 = new Doit_C3_Q1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //숫자 개수 입력
        String str = sc.next(); //n개의 숫자 입력
        System.out.println(q1.solution(str));
    }
}
