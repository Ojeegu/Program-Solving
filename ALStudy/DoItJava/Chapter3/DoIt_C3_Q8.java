package DoItJava.Chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DoIt_C3_Q8 { //좋은 수 구하기
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //수의 개수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) { //arr 배열에 n개의 수 값 입력
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //배열 오름차순 정렬
        int count = 0;
        for(int k = 0; k < n; k++) {
            int find = arr[k]; //arr 배열의 k번째 값을 찾는 값으로 설정
            int i = 0; //arr[i] = arr[0] : 배열의 가장 처음 값(가장 작은 값)
            int j = n-1; //arr[n-1] : 배열의 가장 끝 값(가장 큰 값)
            while(i < j) { //i가 j보다 크면 반복문 종료
                if(arr[i] + arr[j] == find) { //서로 다른 두 수의 합이 갑옷의 특정 수와 같은 경우
                    if(i != k && j != k) {
                        count++;
                        break;
                    }
                    else if(i == k) i++;
                    else j--;
                }
                else if(arr[i] + arr[j] < find) i++;
                else j--;
            }
        }
        System.out.println(count);
    }
}
