package DoItJava.Chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Doit_C4_Q16 { //버블 소트 프로그램
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Data[] data = new Data[N];
        for(int i = 0; i < N; i++) {
            data[i] = new Data(i, Integer.parseInt(br.readLine())); //Data 객체 생성 후 인덱스와 값 설정
        }
        Arrays.sort(data); //arr 배열을 오름차순으로 정렬
        int max = 0; //기존 인덱스와 정렬 후 인덱스 차이를 비교하기 위한 변수
        for(int i = 0; i < N; i++) {
            if(max < (data[i].index - i)) { //기존 인덱스에서 sort 정렬 후 인덱스를 뺀 값 중 가장 큰 값
                max = data[i].index - i; //버블 정렬을 완성시키기까지 돌아야 하는 루프 수
            }
        }
        System.out.println(max + 1); //'+1'은 버블 정렬 완성 후 확인용(=버블이 발생하지 않는 걸 확인하는) 루프문을 추가한 것
    }
}

class Data implements Comparable<Data> {
    int index; //배열의 인덱스
    int value; //배열의 값
    public Data(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Data d) {
        return this.value - d.value;
    } //배열의 값 기준 오름차순 정렬
}

