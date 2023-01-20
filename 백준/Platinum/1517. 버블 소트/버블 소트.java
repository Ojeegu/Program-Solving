import java.io.*;
import java.util.*;
public class Main {
    static long[] arr, tmp;
    static long count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        tmp = new long[n];
        count = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, n-1);
        System.out.println(count);
    }
    static void mergeSort(int start, int end) {
        if(start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            merge(start, end, mid);
        }
    }
    static void merge(int start, int end, int mid) {
        for(int i = start; i <= end; i ++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid+1;
        int index = start;
        while(part1 <= mid && part2 <= end) {
            if(tmp[part1] > tmp[part2]) {
                arr[index] = tmp[part2];
                count += part2 - index;
                part2++;
            }
            else {
                arr[index] = tmp[part1];
                part1++;
            }
            index++;
        }
        while(part1 <= mid) {
            arr[index] = tmp[part1];
            part1++;
            index++;
        }

    }
}
