import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == '(') stack.push(arr[i]);
            else if(stack.isEmpty() && arr[i] == ')') answer = false;
            else {
                if(stack.pop() == ')') answer = false;
            }
        }
        if(!stack.isEmpty()) answer = false;
        return answer;
    }
}