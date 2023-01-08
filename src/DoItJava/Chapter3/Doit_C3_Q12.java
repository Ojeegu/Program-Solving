package DoItJava.Chapter3;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Doit_C3_Q12 { //오큰수 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //수열의 크기 입력
        int[] nArr = new int[N];
        int[] NGE = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) { //1~N까지 임의의 수열 순서 입력
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0); //stack이 비어있으면 안되므로 초기값으로 0 push (배열의 인덱스를 의미)
        for(int i = 1; i < N; i++) {
            while(!stack.isEmpty() && nArr[stack.peek()] < nArr[i]) { //stack이 비어있지 않고 오큰수(nArr[i])가 존재하는 경우
                NGE[stack.pop()] = nArr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) { //for문을 다 돈 후에도 stack이 비어있지 않으면 NGE의 나머지 인덱스에는 '-1' 입력
            NGE[stack.pop()] = -1;
        }
        for(int x : NGE) {
           bw.write(x + " ");
        }
        bw.flush();
        bw.close();
    }
}
