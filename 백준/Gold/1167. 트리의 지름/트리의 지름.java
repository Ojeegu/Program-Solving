import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { //트리의 지름
    static ArrayList<Node>[] nodeArr;
    static boolean[] visited;
    static int max;
    static int node; //가장 긴 노드값을 가지는 인덱스를 저장할 변수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int v = Integer.parseInt(br.readLine()); //트리의 정점 개수 입력
        nodeArr = new ArrayList[v+1]; //Node 객체를 저장할 arrayList 생성
        max = Integer.MIN_VALUE; // 가장 긴 노드값 저장할 변수
        for(int i = 1; i < v+1; i++) { //인접리스트 생성
            nodeArr[i] = new ArrayList<>();
        }
        for(int i = 0; i < v; i++) { //입력값 한 줄씩 저장
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while(true) {
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                nodeArr[from].add(new Node(to, cost));
            }
        }
        visited = new boolean[v+1];
        DFS(1, 0); //임의의 노드(1)에서부터 가장 먼 노드를 찾는 메서드

        visited = new boolean[v+1]; //초기화
        DFS(node, 0); //1차 DFS에서 찾은 node값부터 가장 먼 노드까지의 거리

        System.out.println(max);
    }

    static void DFS(int from, int distance) {
        if(max < distance) {
            max = distance;
            node = from;
        }
        visited[from] = true;
        for(int i = 0; i < nodeArr[from].size(); i++) {
            Node nowNode = nodeArr[from].get(i);
            int nowTo = nowNode.edge;
            int nowCost = nowNode.cost;
            if(!visited[nowTo]) {
                visited[nowTo] = true;
                DFS(nowTo, distance+nowCost);
            }
        }
    }
}

class Node {
    int edge;
    int cost;
    public Node(int edge, int cost) {
        this.edge = edge;
        this.cost = cost;
    }
}

