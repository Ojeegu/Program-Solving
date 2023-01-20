package DoItJava.Chapter3;

import java.util.Scanner;

public class Doit_C3_Q2 { //평균 구하기
    public double solution(int num, double[] score) {
        double sumS = 0; //조작 점수 합계를 저장할 변수
        double maxS = 0; //실제 시험 점수 중 가장 높은 점수를 저장할 변수
        for(double x : score) {
            sumS += x; //반복문을 돌리며 score 배열에 있는 모든 점수를 합산
            maxS = Math.max(maxS, x); //score 배열 중 가장 큰 숫자를 찾아 저장
        }
        return sumS / maxS * 100 / num;
    }

    public static void main(String[] args) {
        Doit_C3_Q2 q2 = new Doit_C3_Q2();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); //과목 수 입력
        double[] score = new double[num]; //num 크기의 실수형 1차원 배열 생성
        for(int i=0; i<num; i++) {
            score[i] = sc.nextInt(); //score 배열에 점수 입력
        }
        System.out.println(q2.solution(num, score));
    }
}
