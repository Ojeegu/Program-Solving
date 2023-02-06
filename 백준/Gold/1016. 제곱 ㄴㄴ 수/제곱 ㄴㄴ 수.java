import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] checkArr = new boolean[(int)(max-min) +1];
        long sqrtMax = (long)Math.sqrt(max);

        for(long i = 2; i <= sqrtMax; i++) {
            long pow = i * i;
            long start = 0;
            if(min % pow != 0) start = pow - (min % pow);

            for(long j = start; j < checkArr.length; j += pow) {
                checkArr[(int)j] = true;
            }
        }

        int count = 0;
        for(int i = 0; i < checkArr.length; i++) {
            if(!checkArr[i]) count++;
        }

        System.out.println(count);
    }
}
