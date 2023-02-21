import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken()); //정점 개수
        int edge = Integer.parseInt(st.nextToken()); //간선 개수
        int start = Integer.parseInt(br.readLine()); //시작 정점

        ArrayList<ArrayList<Edge>> list = new ArrayList<>();
        boolean[] isVisited = new boolean[vertex + 1];
        int[] length = new int[vertex + 1];
        for(int i = 0; i < vertex+1; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 1; i < vertex+1; i++) {
            length[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); //정점 u
            int v = Integer.parseInt(st.nextToken()); //정점 v
            int w = Integer.parseInt(st.nextToken()); //가중치
            list.get(u).add(new Edge(v, w));
        }

        PriorityQueue<Edge> pQueue = new PriorityQueue<>();
        pQueue.add(new Edge(start, 0));
        length[start] = 0;

        while(!pQueue.isEmpty()) {
            Edge now = pQueue.poll();
            if(isVisited[now.vertex]) continue;
            isVisited[now.vertex] = true;
            for(Edge e : list.get(now.vertex)) {
                if(length[e.vertex] > length[now.vertex] + e.value) {
                    length[e.vertex] = length[now.vertex] + e.value;
                    pQueue.add(new Edge(e.vertex, length[e.vertex]));
                }
            }
        }

        for(int i = 1; i < vertex + 1; i++) {
            if(isVisited[i]) System.out.println(length[i]);
            else System.out.println("INF");
        }
    }
}

class Edge implements Comparable<Edge> {
    int vertex;
    int value;
    Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    public int compareTo(Edge e) {
        return this.value - e.value;
    }
}
