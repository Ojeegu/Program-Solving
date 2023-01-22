import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { //미로 탐색하기
    static int[][] maze;
    static boolean[][] visited;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //미로의 행
        m = Integer.parseInt(st.nextToken()); //미로의 열
        maze = new int[n][m]; //n*m 미로 선언
        for(int i = 0; i < n; i++) { //미로 배열에 숫자 입력
            String mazeSetting = br.readLine();
            for(int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(mazeSetting.substring(j, j + 1));
            }
        }
        visited = new boolean[n][m];
        visited[0][0] = true;
        BFS(0, 0);
        System.out.println(maze[n-1][m-1]);
    }

    static void BFS(int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) { //좌표 유효성 검사
                    if(maze[nextX][nextY] != 0 && !visited[nextX][nextY]) { //갈수 있는 좌표인지 검사
                        visited[nextX][nextY] = true; //유효한 좌표 이동 시 체크
                        maze[nextX][nextY] = maze[now[0]][now[1]] + 1; //카운팅
                        queue.offer(new int[] {nextX, nextY}); //유효한 좌표를 queue에 집어넣음
                    }
                }
            }
        }
    }
}
