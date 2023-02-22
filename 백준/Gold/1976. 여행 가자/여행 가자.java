import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); //도시 수
        int m = Integer.parseInt(br.readLine()); //여행 도시

        parent = new int[n+1];
        for(int i = 1; i < n+1; i++) {
            parent[i] = i;
        }

        for(int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n+1; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1) {
                    union(i, j);
                }
            }
        }

        boolean flag = true;
        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        for(int i = 1; i < m; i++) {
            int nextCity = Integer.parseInt(st.nextToken());
            if(!isSame(startCity, nextCity)) flag = false;
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if(findA != findB) parent[findB] = findA;
    }

    private static int find(int a) {
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }

    private static boolean isSame(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        return findA == findB;
    }
}
