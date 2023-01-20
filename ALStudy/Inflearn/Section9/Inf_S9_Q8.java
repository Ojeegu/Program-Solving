package Inflearn.Section9;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Road implements Comparable<Road> {
    int v, cost;
    public Road(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road obj) { //비용을 기준으로 오름차순
        return this.cost - obj.cost;
    }
}

public class Inf_S9_Q8 { //원더랜드(프림)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); //도시 개수
        int e = sc.nextInt(); //도로 개수
        ArrayList<ArrayList<Road>> graph = new ArrayList<>(); //Road 객체를 배열로 저장하는 arryaList 배열 생성(인접배열)
        int[] ch = new int[v+1]; //1~v까지 인덱스를 사용하기 위해 v+1크기로 배열 생성
        for(int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>()); //arryaList 배열 목록에 각 Road형 배열 추가 (1~v까지 사용하므로 v+1개만큼 생성)
        }
        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt(); //v1과 v2 사이의 도로 유지 비용
            graph.get(v1).add(new Road(v2, cost)); //v번째 목록에 Road형 배열 추가
            graph.get(v2).add(new Road(v1, cost)); //이때 간선이 무방향성 특징을 가지므로 v1->v2, v2->v1 두 경우 모두 추가
        }
        int answer = 0; //최소비용을 저장할 변수 초기화
        PriorityQueue<Road> pQ = new PriorityQueue<>(); //비용을 기준으로 최소값을 우선으로 하는 Road형 PriorityQueue 생성
        pQ.offer(new Road(1, 0)); //임의로 1번째 도시를 시작점으로 잡아서 pQ에 추가
        while(!pQ.isEmpty()) {
            Road tmp = pQ.poll(); //현재 pQ에 담아있는 Road 객체 중 cost가 가장 적은 객체를 poll
            int curV = tmp.v; //poll한 Road 객체의 v(도시)를 변수에 저장
            int curC = tmp.cost; //poll한 Road 객체의 cost(비용)를 변수에 저장
            if(ch[curV] == 0) { //현재 선택한 도시가 체크되어 있지 않다면(=집합 안에 없다면)
                ch[curV] = 1; //회로 생성을 방지하기 위해 해당 도시를 ch배열에서 체크함(=이미 집합의 원소임을 표시)
                answer += curC; //도로 비용을 answer 변수에 누적
                for(Road r : graph.get(curV)) { //graph 목록의 curV번째에 들어있는 Road 객체를 호출(curV 도시의 인접 도로)
                    //호출한 Road 객체의 도시가 집합의 원소가 아니라면 해당 Road 객체를 pQ에 추가
                    if(ch[r.v] == 0) pQ.offer(new Road(r.v, r.cost));
                }
            }
        }
        System.out.println(answer); //answer 출력
    }
}
