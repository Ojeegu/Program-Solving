import java.util.Scanner;

public class Main { //배열에서 K번째 수 찾기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int start = 1; //문제에서 인덱스가 1부터 시작한다는 조건이 있으므로
        int end = k; // 임의의 값 x는 k보다 작거나 같으므로
        int answer = 0; //임의의 값 x

        while(start <= end) {
            int mid = (start + end) / 2;
            int count = 0; //임의의 값 x보다 작거나 같은 수의 개수
            for(int i = 1; i < n+1; i++) {
                count += Math.min(mid / i, n); // 'mid/i' 값이 n보다 클 경우 n개만 더함
            }
            if(count < k) { //임의의 값 x보다 작거나 같은 수의 개수가 최소 k개여야 한다는 조건 불충족
                start = mid + 1;
            }
            else { //임의의 값 x보다 작거나 같은 수의 개수가 최소 k개일 때
                answer = mid;
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
