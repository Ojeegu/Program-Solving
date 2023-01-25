import java.util.*;
import java.io.*;
public class Main {
    static int n, m;
    static int[][] maze;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i = 0; i < n; i++) {
            String direction = br.readLine();
            for(int j = 0; j < m; j++) {
                maze[i+1][j+1] = Integer.parseInt(direction.substring(j, j + 1));
            }
        }
        BFS(1, 1);
        System.out.println(maze[n][m]);
    }
    static void BFS(int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] nowPoint = queue.poll();
            int nowX = nowPoint[0];
            int nowY = nowPoint[1];
            for(int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(nextX > 0 && nextX <= n && nextY > 0 && nextY <= m) {
                    if(!visited[nextX][nextY] && maze[nextX][nextY] != 0) {
                        visited[nextX][nextY] = true;
                        maze[nextX][nextY] = maze[nowX][nowY] + 1;
                        queue.offer(new int[] {nextX, nextY});
                    }
                }
            }
        }
    }
}
