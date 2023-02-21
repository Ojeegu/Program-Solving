import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        check = new int[n + 1];
        for(int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            check[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < n+1; i++) {
            if(check[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            sb.append(currentNode + " ");
            for(int x : list.get(currentNode)) {
                check[x]--;
                if(check[x] == 0) {
                    queue.offer(x);
                }
            }
        }
        System.out.println(sb);
    }
}
