import java.io.*;
import java.util.StringTokenizer;

public class Main { //최대공약수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long count = gdc(Math.max(a,b), Math.min(a,b));

        for(int i = 0; i < count; i++) {
            sb.append("1");
        }
        System.out.println(sb);

    }

    static long gdc(long a, long b) {
        if(b == 0) return a;
        else return gdc(b, a%b);
    }
}
