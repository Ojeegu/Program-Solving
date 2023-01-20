package Inflearn.Section9;

import java.util.Scanner;

public class Inf_S9_Q6 { //친구인가 (Union & Find)
    static int[] unf;
    public static int Find(int f) {
        if(f == unf[f]) return f;
        else return unf[f] = Find(unf[f]); // 경로 압축
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 학생수
        int m = sc.nextInt(); // 학생 쌍 수
        unf = new int[n+1]; // 학생 1~n명까지 넣어야하므로 n+1 크기로 생성
        for(int i = 1; i < n+1; i++) unf[i] = i; //nuf 배열 1 ~ n 인덱스에 1 ~ n값 저장
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt(); // 친구관계인 학생쌍을 입력
            Union(a, b);
        }
        int qA = sc.nextInt(); // 친구인지 확인하는 숫자쌍 입력
        int qB = sc.nextInt();
        int fa = Find(qA); //qA의 배열값을 변수 fa에 저장
        int fb = Find(qB); //qB의 배열값을 변수 fb에 저장
        if(fa == fb) System.out.println("YES"); //fa값과 fb값이 같으면 같은 집합이므로 yes 출력
        else System.out.println("NO"); // 같지 않을 경우 같은 집합이 아니므로 no 출력
    }
}
