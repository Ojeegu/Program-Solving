import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { //물통
    static int[] sender = {0, 0, 1, 1, 2, 2}; //물통 인덱스값으로 이용
    static int[] receiver = {1, 2, 0, 2, 0, 1}; //0->1, 0->2, 1->0...
    static boolean[][] visited; //a,b만 알면 c는 고정이므로 2개만 체크
    static boolean[] answer; //c의 최대용량을 배열의 길이로 하고, 나올수 있는 용량의 인덱스는 true, 아니면 false
    static int[] capacity; //a,b,c의 최대값 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        capacity = new int[3];
        capacity[0] = Integer.parseInt(st.nextToken()); // a 최대용량
        capacity[1] = Integer.parseInt(st.nextToken()); // b 최대용량
        capacity[2] = Integer.parseInt(st.nextToken()); // c 최대용량
        visited = new boolean[201][201]; //최대 용량이 200까지이므로
        answer = new boolean[201];

        BFS();

        for(int i = 0; i < answer.length; i++) {
            if(answer[i]) System.out.print(i + " ");
        }
    }

    private static void BFS() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0)); //a=0, b=0, c=10인 AB 클래스 queue에 넣음
        visited[0][0] = true;
        answer[capacity[2]] = true; //a=0이므로 c 초기값 정답 배열에 넣음
        while(!queue.isEmpty()) {
            AB currentQ = queue.poll();
            int a = currentQ.a;
            int b = currentQ.b;
            int c = capacity[2] - a - b; //현재 c값은 최대용량에서 a와 b 값을 뺀 나머지
            for(int i = 0; i < 6; i++) { //경우의 수 6가지 돌리기
                int[] next = {a, b, c}; //다음 물통값 초기화
                next[receiver[i]] += next[sender[i]]; //sender 물통 값을 receiver 물통에 부음
                next[sender[i]] = 0; //sender 물통 다 부었으니 0으로 갱신
                if(next[receiver[i]] > capacity[receiver[i]]) { //합친 물 양이 최대용량을 넘칠때 처리
                    next[sender[i]] = next[receiver[i]] - capacity[receiver[i]]; //초과분만큼 sender에게 다시 주기
                    next[receiver[i]] = capacity[receiver[i]]; //초과분 덜어주었으므로 최대용량으로 갱신
                }
                if(!visited[next[0]][next[1]]) { //a와 b에 저장된 물 양이 이전에 체크하지 않은 조합이라면
                    visited[next[0]][next[1]] = true; //방문 체크
                    queue.add(new AB(next[0], next[1]));
                    if(next[0] == 0) answer[next[2]] = true;
                }
            }
        }
    }
}

class AB {
    int a;
    int b;
    public AB(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
