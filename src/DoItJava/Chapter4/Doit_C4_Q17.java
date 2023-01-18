package DoItJava.Chapter4;

import java.util.Scanner;

public class Doit_C4_Q17 { //소트인사이드(선택정렬)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] arr = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.substring(i, i + 1));
        }
        for(int i = 0; i < str.length(); i++) {
            int max = i; //배열의 맨 앞에 있는 인덱스를 최대값으로 초기화
            for(int j = i+1; j<str.length(); j++) {
                if(arr[j] > arr[max]) max = j; //arr 배열을 돌며 최대값이 들어있는 인덱스를 찾음
            }
            if(arr[i] < arr[max]) {
                int tmp = arr[i];
                arr[i] = arr[max];
                arr[max] = tmp;
            }
        }
        for(int x : arr) {
            System.out.print(x);
        }
    }
}
