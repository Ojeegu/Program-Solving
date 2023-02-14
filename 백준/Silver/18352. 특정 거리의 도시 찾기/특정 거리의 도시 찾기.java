import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> answer;
    static ArrayList<ArrayList<Integer>> cityList;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //도시 개수
        int m = Integer.parseInt(st.nextToken()); //도로 개수
        int k = Integer.parseInt(st.nextToken()); //거리정보
        int x = Integer.parseInt(st.nextToken()); //출발 도시 번호

        answer = new ArrayList<>(); //정답 컬렉션
        cityList = new ArrayList<>(); //도시 컬렉션
       visited = new int[n+1]; //방문 체크

        for(int i = 0; i < n+1; i++) { //이중 ArrayList
            cityList.add(new ArrayList<>());
        }

        for(int i = 1; i < m+1; i++) { //인접리스트 작성
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); //출발 도시
            int end = Integer.parseInt(st.nextToken()); //도착 도시
            cityList.get(start).add(end);
        }

        for(int i = 1; i < n+1; i++) {
            visited[i] = -1; //인덱스 1~n까지 -1로 초기화
        }

        BFS(x);
        for(int i = 1; i < n+1; i++) {
            if(visited[i] == k) {
                answer.add(i);
            }
        }

        if(answer.isEmpty()) {
            System.out.println(-1);
        }
        else {
            Collections.sort(answer); //정렬
            for(int i : answer) {
                System.out.println(i);
            }
        }

    }

    private static void BFS(int city) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(city);
        visited[city]++;
        while(!queue.isEmpty()) {
            int currentCity = queue.poll();
            for(int i : cityList.get(currentCity)) {
                if(visited[i] == -1) {
                    visited[i] = visited[currentCity] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
