package DoItJava.Chapter3;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Doit_C3_Q10 { //최소값 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //수의 개수 입력
        int L = Integer.parseInt(st.nextToken()); //윈도우 범위
        Deque<Node> deque = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) { //n개의 수 입력하여 차례로 now 변수에 저장
            int now = Integer.parseInt(st.nextToken());
            while(!deque.isEmpty() && deque.getLast().value > now) {
                deque.removeLast();
            }
            deque.addLast(new Node(now, i));
            //덱의 첫번째 노드의 인덱스가 현재 노드의 인덱스-윈도우 범위 보다 작거나 같으면 첫번째 노드 삭제
            if(deque.getFirst().index <= i - L) {
                deque.removeFirst();
            }
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
}

class Node {
    int value, index;
    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }
}


