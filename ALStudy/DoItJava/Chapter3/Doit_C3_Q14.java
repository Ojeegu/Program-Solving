package DoItJava.Chapter3;

import java.io.*;
import java.util.PriorityQueue;

public class Doit_C3_Q14 {//절댓값 힙 구현하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //연산의 개수 입력
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((o1, o2) -> { //o1, o2 변수에 대한 정렬 재정의(오름차순)
            int firstAbs = Math.abs(o1); //o1의 절대값
            int secondAbs = Math.abs(o2); //o2의 절대값
            /*
            o1과 o2의 절대값이 같은 경우 o1 > o2 라면 o1(양수) 우선순위 down(1)
                                     o1 < o2 라면 o1(음수) 우선순위 up(-1)
             */
            if(firstAbs == secondAbs) {
                return o1 > o2 ? 1 : -1;
            }
            else return firstAbs - secondAbs; // 절대값이 작은 값을 우선순위로 함
        });
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) { //x가 0이면 배열에서 절대값이 가장 작은 값 출력
                if(pQueue.isEmpty()) { //이때 pQueue 배열이 비어있다면 0 출력
                    System.out.println("0");
                } else System.out.println(pQueue.poll()); //배열이 비어있지 않으면 pQueue 배열에서 가장 우선순위인 수 출력
            }
            else { //x가 0이 아니면 pQueue 배열에 x 추가
                pQueue.add(x);
            }
        }
    }
}
