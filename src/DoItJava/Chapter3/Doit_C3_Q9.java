package DoItJava.Chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Doit_C3_Q9 { //DNA 비밀번호
    static int[] requiredArr;
    static int[] checkMyArr;
    static int meetCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()); //임의로 만든 DNA 문자열의 길이
        int p = Integer.parseInt(st.nextToken()); //비밀번호로 사용할 부분 문자열의 길이
        char[] dnaArr = new char[s]; //임의의 DNA문자열을 저장하는 배열 생성
        //A, C, G, T의 최소 개수 조건을 저장하는 배열 생성 (index[0] : A, index[1] : C, index[2] : G, index[3] : T)
        requiredArr = new int[4];
        checkMyArr = new int[4]; //현재 부분 문자열의 ACGT 개수를 저장하는 배열 생성
        meetCount = 0; //최소 개수 조건을 충족하는 문자의 개수를 카운트(meetCount = 4라면 모든 조건을 충족하므로 새로운 비밀번호 1개 생성)
        int passwordNum = 0;
        dnaArr = br.readLine().toCharArray(); //문자열 입력값을 받아 char 배열로 변환하여 dnaArr 배열에 저장
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) { //requiredArr 배열값 입력하는 반복문
            requiredArr[i] = Integer.parseInt(st.nextToken()); //각 문자별 충족해야 하는 최소 개수 입력
            if(requiredArr[i] == 0) meetCount++; //최소 개수 조건이 0이면 이미 조건을 충족한 것이나 다름없기 때문에 미리 카운트
        }

        for(int i = 0; i < p; i++) {
            Add(dnaArr[i]); //dnaArr 배열값이 ACGT 최소 개수를 충족했는지 체크하는 메서드
        }
        if(meetCount == 4)
            passwordNum++; // ACGT 최소 개수를 모두 충족했다면 새로운 비밀번호 1개 생성되므로 카운팅

        for(int i = p; i < s; i++) { //슬라이딩 윈도우 이동 처리 (p 범위를 유지한 채 오른쪽으로 한 칸 이동)
            int j = i - p; //부분 문자열의 가장 왼쪽 값. 직전 부분 문자열에 포함되어 있었으므로 제외처리 해주어야 함
            Add(dnaArr[i]); //부분 문자열에 새로 추가된 i번째 값만 Add 메서드로 확인
            Remove(dnaArr[j]); //j번째 값을 뺐을 때 요구 충족 현황에 변화가 있는지 확인하는 메서드
            if(meetCount == 4)
                passwordNum++;
        }
        System.out.println(passwordNum);
        br.close();
    }

    public static void Add(char c) { //부분 문자열의 요소를 확인하여 필수 문자가 최소 개수 조건을 충족했는지 체크하는 메서드
        switch(c) {
            case 'A':
                checkMyArr[0]++; // dnaArr 배열의 i번째 문자가 A라면 checkMyArr의 0번째 인덱스(=A 자리)의 값을 증가
                //현재 A의 개수가 요구 조건과 동일하다면 meetCount 증가 ('같거나 크다'로 설정할 경우 중복 카운팅 되므로 같을 때 한 번만 카운트)
                if (requiredArr[0] == checkMyArr[0])
                    meetCount++;
                break;

            case 'C':
                checkMyArr[1]++;
                if (requiredArr[1] == checkMyArr[1])
                    meetCount++;
                break;

            case 'G':
                checkMyArr[2]++;
                if (requiredArr[2] == checkMyArr[2])
                    meetCount++;
                break;

            case 'T':
                checkMyArr[3]++;
                if (requiredArr[3] == checkMyArr[3])
                    meetCount++;
                break;
        }
    }

    public static void Remove(char c) {
        switch (c) {
            case 'A':
                if(requiredArr[0] == checkMyArr[0])
                    meetCount--;
                checkMyArr[0]--;
                break;

            case 'C':
                if(requiredArr[1] == checkMyArr[1])
                    meetCount--;
                checkMyArr[1]--;
                break;

            case 'G':
                if(requiredArr[2] == checkMyArr[2])
                    meetCount--;
                checkMyArr[2]--;
                break;

            case 'T':
                if(requiredArr[3] == checkMyArr[3])
                    meetCount--;
                checkMyArr[3]--;
                break;
        }
    }
}
