import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int sqrtMax = (int)Math.sqrt(max);
        boolean[] checkArr = new boolean[(int)(max - min) + 1];
        for(long i = 2; i <= sqrtMax; i++) {
            long pow = i*i;
            long start = pow - (min % pow);
            if(min % pow == 0) start = 0;
            for(long j = start; j < checkArr.length; j += pow) {
                checkArr[(int)j] = true;
            }
        }
        int	count = 0;
        for(int i = 0; i < checkArr.length; i++) {
            if(!checkArr[i]) count++;
        }
        System.out.println(count);
    }
}
