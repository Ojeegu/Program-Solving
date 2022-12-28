package Inflearn.Section9;

import java.util.*;

class Body implements Comparable<Body>{
    int h, w; //키와 몸무게 변수 선언
    public Body(int h, int w) {
        this.h = h;
        this.w = w;
    }
    
    @Override
    public int compareTo(Body obj) { //키를 기준으로 내림차순 정렬하도록 오버라이딩
        return obj.h - this.h;
    }
}

public class Inf_S9_Q1 { //씨름선수
    public int solution(ArrayList<Body> arr) { // 최대인원 계산하여 return하는 메서드
        Collections.sort(arr); // arr을 키 기준 내림차순으로 정렬
        int max = Integer.MIN_VALUE; // 몸무게 값을 비교하기 위해 변수를 최소값으로 초기화
        int count = 0; //인원을 저장하는 변수
        //이미 키를 내림차순 정렬했으므로 i번째 몸무게 > i+1번째 몸무게인 지원자는 탈락함
        for(Body o : arr) {
            if(o.w > max) {
                count++; //i+1번째 몸무게 < i번째 몸무게인 경우 선발
                max = o.w;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Inf_S9_Q1 q1 = new Inf_S9_Q1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //지원자 수
        ArrayList<Body> arr = new ArrayList<>(); //키와 몸무게를 저장하는 body형 arrayList 생성
        for(int i = 0; i < n; i++) {
            int h = sc.nextInt(); //키 입력
            int w = sc.nextInt(); //몸무게 입력
            arr.add(new Body(h, w)); //입력받은 키와 몸무게 값을 arr 배열에 저장
        }
        System.out.println(q1.solution(arr));
    }
}
