import java.io.*;

public class Main {
    static int[] arr, tmp;
    public void mergeSort(int start, int end) {
        if(start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    public void merge(int start, int mid, int end) {
        for(int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while(part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        while(part1 <= mid) {
            arr[index] = tmp[part1];
            index++;
            part1++;
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tmp = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        main.mergeSort(0, n-1);
        for(int x : arr) {
            bw.write(x + "\n");
        }
        bw.flush();
        bw.close();
    }
}