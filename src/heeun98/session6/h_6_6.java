package heeun98.session6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class h_6_6 {


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


        int lt = arr[n - 1];
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {

            int mid = (lt + rt) / 2;
            int sum = 0;
            int count = 1;
            for (int i = 0; i < n; i++) {

                if (sum + arr[i] <= mid) {
                    sum += arr[i];
                } else {
                    sum = arr[i];
                    count++;
                }
            }


            if (count <= m) {
                rt = mid;
            } else {
                lt = mid + 1;
            }


            if (lt == rt) {
                System.out.println(lt);
                return;
            }

        }
    }
}
