import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); //건물 수
        int[] buildTime = new int[n + 1];
        int[] input = new int[n + 1];
        ArrayList<ArrayList<Integer>> buildingList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            buildingList.add(new ArrayList<>());
        }
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken()); //각 건물의 공사 시간
            while (true) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == -1) break;
                buildingList.get(tmp).add(i);
                input[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (input[i] == 0) queue.offer(i);
        }
        int[] result = new int[n + 1];
        while (!queue.isEmpty()) {
            int currentB = queue.poll();
            for (int nextB : buildingList.get(currentB)) {
                input[nextB]--;
                result[nextB] = Math.max(result[nextB], result[currentB] + buildTime[currentB]);
                if (input[nextB] == 0) queue.offer(nextB);
            }
        }
        for (int i = 1; i < n + 1; i++) {
            System.out.println(result[i] + buildTime[i]);
        }
    }
}
