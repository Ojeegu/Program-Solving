package Inflearn.Section9;

import java.util.*;

class Schedule implements Comparable<Schedule>{
    int money, date;
    public Schedule(int money, int date) {
        this.money = money;
        this.date = date;
    }

    @Override
    public int compareTo(Schedule obj) { //기한을 기준으로 내림차순 정렬하도록 오버라이딩
        return obj.date - this.date;
    }
}

public class Inf_S9_Q4 { //최대수입스케쥴(PriorityQueue)
    static int max = Integer.MIN_VALUE; //기한을 저장하는 변수 d값과 비교하여 가장 큰 값을 저장하기 위해 최소값으로 초기화
    public int solution(ArrayList<Schedule> arr, int n) {
        //최대값을 우선순위로 하는 정수형 priority queue 생성
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr); //기한을 기준으로 내림차순 정렬
        int answer = 0; // 수입을 누적할 변수
        int j = 0; // for문 실행 시 j값이 중첩에 의해 중복되지 않도록 루프 밖에서 초기화
        for(int i = max; i > 0; i--) { //가장 긴 날짜부터 1일까지 반복문 돌림
            for(; j < n; j++) {
                if(arr.get(j).date < i) { //arr의 j번째 기한이 i값 보다 작은 경우 break
                    break;
                }
                else pQ.offer(arr.get(j).money); //arr의 j번째 기한이 i값과 같거나 큰 경우 j번째 강의료를 pQ에 추가
            }
            if(!pQ.isEmpty()) answer += pQ.poll(); //pQ에 저장된 값 중 가장 높은 강의료를 poll하여 answer에 누적
        }
        return answer;
    }

    public static void main(String[] args) {
        Inf_S9_Q4 q4 = new Inf_S9_Q4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //강연 요청 수
        ArrayList<Schedule> arr = new ArrayList<>(); //강연료와 기한을 저장하는 arrayList 생성
        for(int i = 0; i < n; i++) {
            int m = sc.nextInt(); //강연료 입력
            int d = sc.nextInt(); //기한 입력
            arr.add(new Schedule(m, d)); //입력받은 강연료와 기한을 arrayList에 추가
            if(d > max) max = d; //기한 입력값 중 가장 큰 값을 max에 저장
        }
        System.out.println(q4.solution(arr, n));
    }
}
