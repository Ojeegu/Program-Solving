package DoItJava.Chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Doit_C3_Q13 { //카드게임
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //카드 장 수 입력
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < N+1; i++) { //1 ~ N까지의 수를 순서대로 queue에 add
            queue.add(i);
        }
        while(queue.size() > 1) { //카드 1장만 남을 때까지 while 반복문 실행
            queue.poll(); //가장 앞에 있는 수 poll
            queue.add(queue.poll()); //남아있는 수 중 가장 앞에 있는 수를 poll한 뒤 맨 뒤로 add
        }
        System.out.println(queue.poll());
    }
}
