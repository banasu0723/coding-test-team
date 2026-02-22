package heeun98.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class m_12 {

    static long answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());


        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long lt = 1;
        long rt = Arrays.stream(arr).max().getAsInt();

        while (lt <= rt) {

            long mid = (lt + rt) / 2;
            long count = 0;
            for (int i = 0 ; i < arr.length ;i++) {
                count += arr[i] / mid;
            }

            if (count >= n) {
                answer = Math.max(answer, mid);
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }

        }

        System.out.println(answer);
    }
}
