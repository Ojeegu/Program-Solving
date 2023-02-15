import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main { //이분 탐색 그래프
    static ArrayList<ArrayList<Integer>> list;
    static int[] partition;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++) { //테스트 케이스만큼 입력값 받기
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken()); //정점 개수
            int edge = Integer.parseInt(st.nextToken()); //간선 개수

            list = new ArrayList<>();
            for (int j = 0; j < vertex + 1; j++) { //테스트 케이스 당 이중 컬렉션 생성
                list.add(new ArrayList<>());
            }

            for (int k = 0; k < edge; k++) { //테스트 케이스 당 인접리스트 설정
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list.get(u).add(v);
                list.get(v).add(u);
            }

            partition = new int[vertex + 1];
            visited = new boolean[vertex + 1];
            flag = true;

            for(int m = 1; m < vertex+1; m++) {
                if(!flag) break;
                DFS(m);
            }

            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void DFS(int start) {
        visited[start] = true;
        for(int x : list.get(start)) {
            if(!visited[x]) {
                partition[x] = (partition[start] + 1) % 2; //0,1만 들어가도록 함
                DFS(x);
            }
            else if(partition[x] == partition[start]) {
                flag = false;
            }
        }
    }
}
