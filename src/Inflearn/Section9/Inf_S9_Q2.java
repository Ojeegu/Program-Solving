package Inflearn.Section9;

import java.util.*;

class Lecture implements Comparable<Lecture> { //시작시간, 끝시간을 저장
    int start, end;
    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lecture obj) { //끝시간을 기준으로 오름차순, 끝시간이 같을 경우 시작시간을 기준으로 오름차순하도록 오버라이딩
        if(this.end == obj.end) return this.start - obj.start;
        else return this.end - obj.end;
    }
}

public class Inf_S9_Q2 { //회의실 배정
    public int solution(ArrayList<Lecture> arr) {
        Collections.sort(arr); //끝나는 시간을 기준으로 오름차순으로 정렬(끝나는 시간이 같을 경우 시작 시간을 기준으로 오름차순)
        int count = 0; //회의실 사용 횟수를 저장하는 변수
        int dTime = 0; //직전 회의의 끝나는 시간을 저장하는 변수
        for(Lecture l : arr) {
            if(l.start >= dTime) { //현재 회의의 시작 시간이 직전 회의의 끝나는 시간보다 크거나 같다면 회의실 사용 가능
                count++; //회의실 사용 횟수 추가
                dTime = l.end; //회의 끝나는 시간 갱신
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Inf_S9_Q2 q2 = new Inf_S9_Q2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //회의의 수
        ArrayList<Lecture> arr = new ArrayList<>(); // 회의 시작시간과 끝시간을 저장하는 Lecture형 arrayList를 생성
        for(int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr.add(new Lecture(start, end));
        }
        System.out.println(q2.solution(arr));
    }
}
