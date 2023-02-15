import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<ArrayList<Integer>> computer;
	static boolean[] visited;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		computer = new ArrayList<>();
		answer = new int[n+1];
		for(int i = 0; i < n+1; i++) {
			computer.add(new ArrayList<>());
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			computer.get(a).add(b);
		}
		for(int i = 1; i < n+1; i++) {
			visited = new boolean[n+1];
			BFS(i);
		}
		int max = 0;
		for(int i = 1; i < n+1; i++) {
			max = Math.max(answer[i], max);
		}
		for(int i = 1; i < n+1; i++) {
			if(answer[i] == max) sb.append(i + " ");
		}
		System.out.print(sb);
	}
	private static void BFS(int com) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(com);
		visited[com] = true;
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
