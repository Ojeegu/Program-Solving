package Inflearn.Section9;

import java.util.*;

class Person implements Comparable<Person>{ //시간과 현상태를 변수로 받음
    int time;
    char state;
    public Person(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Person obj) { //시간을 기준으로 오름차순 정렬하며 만약 시간이 같을 경우 도착상태(l)가 먼저 오도록 오버라이딩
        if(this.time == obj.time) return obj.state - this.state;
        else return this.time - obj.time;
    }
}

public class Inf_S9_Q3 { //결혼식
    public int solution(ArrayList<Person> arr) { //각 시간의 정각을 기준으로 피로연장에 존재하는 최대 인원 계산
        Collections.sort(arr);
        int count = 0; //동시간대 인원수를 저장하는 변수
        int answer = Integer.MIN_VALUE; //루프 실행 시 가장 큰 count값을 저장하기 위해 최소값으로 초기화한 변수
        for(Person p : arr) {
            if(p.state == 'a') { //현재 상태가 도착상태인 경우 count를 증가하고 count값과 직전 answer값 중 더 큰 값으로 answer 갱신
                count++;
                answer = Math.max(answer, count);
            }
            else count--; //현재 상태가 떠나는 상태(l)인 경우 count를 감소
        }
        return answer;
    }

    public static void main(String[] args) {
        Inf_S9_Q3 q3 = new Inf_S9_Q3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //피로연 참석자 수
        ArrayList<Person> arr = new ArrayList<>(); // 참석자의 오는 시간과 가는 시간을 시간, 상태로 나누어 저장하는 배열 생성
        for(int i = 0; i < n; i++) {
            int arrive = sc.nextInt(); //도착하는 시간
            int leave = sc.nextInt(); //떠나는 시간
            arr.add(new Person(arrive, 'a')); //도착 시간을 시간과 상태(a)로 나누어 배열에 추가
            arr.add(new Person(leave, 'l')); //떠나는 시간을 시간과 상태(l)로 나누어 배열에 추가
        }
        System.out.println(q3.solution(arr));
    }
}
