package DoItJava.Chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Doit_C3_Q11 { //스택으로 오름차순 수열 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력객체
        StringBuffer bf = new StringBuffer(new StringBuffer()); //출력객체
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; //수열의 개수 입력
        for(int i = 0; i < n; i++){ //stack을 통해 출력하고 싶은 임의의 수열 순서 입력
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1; //숫자 1~n까지 오름차순으로 push 해야하므로 1로 초기화
        boolean flag = true; //stack이 num과 arr의 순서에 맞게 후입선출 되는지 확인하는 변수(후입선출 실패시 false)
        for(int i = 0; i < n; i++) {
            if(arr[i] >= num) { // arr[i]와 같아질 때까지 num을 오름차순으로 push
                while(arr[i] >= num){
                    stack.push(num++); // stack.push(num)과 num++을 한줄로 표현
                    bf.append("+\n"); //push 했으므로 '+'
                } //arr[i] < num이 되는 순간 while문 종료
                stack.pop(); //arr[i] = num인 수를 pop
                bf.append("-\n"); //pop 했으므로 '-'
            }
            else if(arr[i] < num) {
                if(arr[i] == stack.pop()) { //arr[i]가 num 보다 작고 stack.top과 같은 경우 후입선출 조건을 만족하므로 pop
                    bf.append("-\n");
                }
                else { //같지 않은 경우 후입선출 조건에 어긋나므로 flag 값을 false로 바꾸고 no 출력
                    System.out.println("NO");
                    flag = false;
                    break;
                }
            }
        }
        if(flag) System.out.print(bf); //만약 문자열로 출력하고 싶으면 System.out.print(bf.toString());
    }
}
