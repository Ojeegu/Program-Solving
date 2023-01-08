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
        for(int i = 0; i < n; i++){ //수열을 이루는 정수 입력
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1; //수열의 값과 비교할 숫자. 수열의 크기가 1보다 같거나 크므로 1로 초기화
        boolean flag = true; //수열 출력 여부를 저장하는 변수
        for(int i = 0; i < n; i++) {
            if(arr[i] >= num) {
                while(arr[i] >= num){
                    stack.push(num++); // stack.push(num)과 num++을 한줄로 표현
                    bf.append("+\n"); //push 했으므로 '+'
                } //arr[i] < num이 되는 순간 while문 종료
                stack.pop(); //stack top에 arr[i] = num의 값이 저장된 상태에서 pop
                bf.append("-\n"); //pop 했으므로 '-'
            }
            else if(arr[i] < num) {
                if(arr[i] == stack.pop()) { //stack top 값이 arr[i]와 같으면 그대로 출력
                    bf.append("-\n");
                }
                else { //같지 않은 경우 stack을 비울 수 없으므로 no를 출력
                    System.out.println("NO");
                    flag = false; //오름차순 출력이 불가능하므로 flag 값을 false로 바꿈
                    break;
                }
            }
        }
        if(flag) System.out.print(bf); //만약 문자열로 출력하고 싶으면 System.out.print(bf.toString()); 처리
    }
}
