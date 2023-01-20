import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { //DFS와 BFS 프로그램
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //노드의 개수
        int m = Integer.parseInt(st.nextToken()); //에지의 개수
        int v = Integer.parseInt(st.nextToken()); //탐색을 시작할 노드의 번호
        list = new ArrayList<>();
        for(int i = 0; i < n+1; i++) { //list 안에 1~n까지의 인접리스트 생성
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) { //m개의 노드 양방향으로 추가
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i = 1; i < n+1; i++) { //작은 노드부터 방문하기 위해 list 배열의 인접리스트를 오름차순 정렬
            Collections.sort(list.get(i));
        }
        visited = new boolean[n+1]; //visited 배열 초기화
        DFS(v);
        System.out.println();
        visited = new boolean[n+1]; //visited 배열 초기화
        BFS(v);

    }

    static void DFS(int v) {
        System.out.print(v + " ");
        visited[v] = true;
        for(int u : list.get(v)) {
            if(!visited[u]) DFS(u);
        }
    }

    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int nowV = queue.poll();
            System.out.print(nowV + " ");
            for(int u : list.get(nowV)) {
                if(!visited[u]) {
                    visited[u] = true;
                    queue.add(u);
                }
            }
        }
    }
}
