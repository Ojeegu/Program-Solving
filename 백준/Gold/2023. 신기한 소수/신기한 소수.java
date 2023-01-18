import java.util.Scanner;

public class Main { //신기한 소수
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    private static void DFS(int number, int digit) {
        if(digit == n) { //n의 자리 수
            if (isPrime(number)) {
                System.out.println(number);
            }
            return;
        }

        for(int i = 1; i < 10; i++) {
            if(i % 2 == 0) continue;
            int nextNum = number * 10 + i;
            if(isPrime(nextNum)) {
                DFS(nextNum, digit + 1); //nextNum을 다시 DFS로 넘기고 자리수 1 추가
            }
        }
    }

    private static boolean isPrime(int number) {
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}
