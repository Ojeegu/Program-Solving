import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main { //친구 관계 파악하기
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static boolean isValid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        visited = new boolean[n]; //방문 정점 체크용 배열
        isValid = false; //DFS가 5번 이상 들어갔는지 체크하는 변수
        for(int i = 0; i < n; i++) { //list에 n개의 arryaList 객체 생성
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) { //양방향 노드 추가
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }
        for(int i = 0; i < n; i++) {
            DFS(i, 1);
            if(isValid) break;
        }
        if(isValid) System.out.println(1);
        else System.out.println(0);
    }

    static void DFS(int v, int count) {
        if (count == 5 || isValid) {
            isValid = true;
            return;
        }
        visited[v] = true;
        for (int u : list.get(v)) {
            if(!visited[u]) {
                DFS(u, count + 1);
            }
        }
        visited[v] = false;
    }
}
