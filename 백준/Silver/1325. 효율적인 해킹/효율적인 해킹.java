import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] answer;
    static ArrayList<ArrayList<Integer>> computer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //컴퓨터 개수
        int m = Integer.parseInt(st.nextToken()); //신뢰관계 수

        answer = new int[n+1];
        computer = new ArrayList<>();
        visited = new boolean[n+1];

        for(int i = 0; i < n+1; i++) {
            computer.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computer.get(a).add(b); //a->b 신뢰
        }

        for(int i = 1; i < n+1; i++) { //모든 컴퓨터를 확인하면서 answer배열 갱신
            visited = new boolean[n+1]; //배열 초기화
            BFS(i);
        }
        int max = 0;
        for(int i = 1; i < n+1; i++) {
            max = Math.max(max, answer[i]);
        }
        for(int i = 1; i < n+1; i++) {
            if(answer[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    private static void BFS(int comIndex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(comIndex);
        visited[comIndex] = true;
        while(!queue.isEmpty()) {
            int currentCom = queue.poll();
            for(int x : computer.get(currentCom)) {
                if(!visited[x]) {
                    visited[x] = true;
                    answer[x]++;
                    queue.add(x);
                }
            }
        }
    }
}
