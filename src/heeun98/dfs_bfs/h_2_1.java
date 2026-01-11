package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class h_2_1 {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        String input = br.readLine();
        st = new StringTokenizer(input);


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = arr[0];
        int rt = Arrays.stream(arr).sum();


        while (lt <= rt) {

            int mid = (lt + rt) / 2;
            int sum = 0;
            int count = 0;

            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum > mid) {
                    sum = arr[i];
                    count++;
                }
            }
            if (sum <= mid) count++;
            if (count == m) {
                answer = mid;
                rt = mid - 1;
                continue;
            }
            if (count < m) {
                rt = mid - 1;
                continue;
            }
            if (count > m) {
                lt = mid + 1;
            }

        }


        System.out.println(answer);


    }
}
