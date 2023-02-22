import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken()); //학생수
        int m = Integer.parseInt(st.nextToken()); //비교 회수
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] input = new int[n+1];
        for(int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            input[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < n+1; i++) {
            if(input[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current + " ");
            for(int next : list.get(current)) {
                input[next]--;
                if(input[next] == 0) queue.offer(next);
            }
        }
        System.out.print(sb);
    }
}
