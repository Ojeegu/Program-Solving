import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> party; //파티 컬렉션
    static int[] truthPerson; //진실을 아는 사람
    static int[] repPerson; //각 파티별 대표자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()); //첫번째 줄
        int n = Integer.parseInt(st.nextToken()); //사람 수
        int m = Integer.parseInt(st.nextToken()); //파티 수
        party = new ArrayList<>(); //파티 인접리스트
        for(int i = 0; i < m; i++) {
            party.add(new ArrayList<>());
        }
        repPerson = new int[n + 1]; //대표노드
        for(int i = 0; i < n + 1; i++) { //대표노드 초기화
            repPerson[i] = i;
        }

        st = new StringTokenizer(br.readLine()); //두번째 줄
        int truthNum = Integer.parseInt(st.nextToken()); //진실을 아는 사람 수
        truthPerson = new int[truthNum];
        for(int i = 0; i < truthNum; i++) {
            truthPerson[i] = Integer.parseInt(st.nextToken()); //진실을 아는 사람 배열에 저장
        }

        for(int i = 0; i < m; i++) { //각 파티별 참석하는 사람
            st = new StringTokenizer(br.readLine()); //세번째 줄 이후
            int numOfPeople = Integer.parseInt(st.nextToken()); //각 파티별 참석자 수
            for(int j = 0; j < numOfPeople; j++) { //파티 인접리스트
                int person = Integer.parseInt(st.nextToken());
                party.get(i).add(person);
            }
        }

        for(int i = 0; i < m; i++) { //각 party를 union화
            int firstPerson = party.get(i).get(0);
            for(int j = 0; j < party.get(i).size(); j++) {
                union(firstPerson, party.get(i).get(j));
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            boolean flag = true;
            int currentV = party.get(i).get(0);
            for(int j = 0; j < truthPerson.length; j++) {
                if(isSame(currentV, truthPerson[j])) { //파티 참석자와 진실을 아는 사람이 동일하면
                    flag = false; //말할 수 없음
                    break;
                }
            }
            if(flag) count++; //만약 파티에 진실 아는 사람이 아무도 없으면 카운트
        }
        System.out.println(count);
    }

    private static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);
        if(findA != findB) repPerson[findB] = findA;
    }

    private static int find(int a) {
        if (a == repPerson[a]) return a;
        else return repPerson[a] = find(repPerson[a]);
    }

    private static boolean isSame(int a, int b) {
        int findA = find(a);
        int findB = find(b);
        return findA == findB;
    }
}
