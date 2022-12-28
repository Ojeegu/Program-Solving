package Inflearn.Section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int v1, v2, cost;
    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge obj) { //유지비용을 기준으로 오름차순 정렬하도록 오버라이딩
        return this.cost - obj.cost;
    }
}

public class Inf_S9_Q7 { //원더랜드(최소 스패닝 트리, 크루스칼)
    static int[] unf;
    public static int Find(int f) {
        if(f == unf[f]) return f;
        else return unf[f] = Find(unf[f]);
    }

    public static void Union(int v1, int v2) {
        int fV1 = Find(v1);
        int fV2 = Find(v2);
        if(fV1 != fV2) unf[fV1] = fV2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Edge> arr = new ArrayList<>();
        int v = sc.nextInt(); //도시 개수 입력
        int e = sc.nextInt(); //도로 개수 입력
        unf = new int[v+1];
        for(int i = 1; i < v+1; i++) unf[i] = i;
        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt(); //v1도시와 v2도시 간의 도로 유지비용
            arr.add(new Edge(v1, v2, cost));
        }
        Collections.sort(arr); //arrayList 배열을 cost 기준으로 오름차순 정렬
        int answer = 0; //최소 비용 초기화
        for(Edge o : arr) {
            int fV1 = Find(o.v1);
            int fV2 = Find(o.v2);
            if(fV1 != fV2) {
                answer += o.cost;
                Union(o.v1, o.v2);
            }
        }
        System.out.println(answer);
    }
}
