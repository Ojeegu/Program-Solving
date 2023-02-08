import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { //오일러의 피
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long euler = n;
        for(long i = 2; i <= Math.sqrt(n); i++) { //에라토리스의 체 활용
            if(n % i == 0) { //i가 n의 약수면
                euler = euler - (euler / i); //오일러 공식
            }
            while(n % i == 0) {
                n = n / i; //약수로 나눠줌
            }
        }
        if(n != 1) { //1 외에 나눌 수 있는 수가 더 있는 경우
            euler = euler - (euler / n); //한번 더 오일러 공식
        }
        System.out.println(euler);
    }
}
