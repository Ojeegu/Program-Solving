import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main { //수 정렬하기2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);
        for(int x : arr) {
            bw.write(x + "\n");
        }
        bw.flush();
        bw.close();
    }
}