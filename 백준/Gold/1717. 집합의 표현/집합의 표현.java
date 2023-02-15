import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //집합의 표현
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for(int i = 0; i < n+1; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int request = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(request == 0) {
                union(a, b);
            }
            else {
                if(isSame(a, b)) System.out.println("YES");
                else System.out.println("NO");
                }
            }
        }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }

    private static int find(int a) {
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }

    private static boolean isSame(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }
}
