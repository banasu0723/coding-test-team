package heeun98.session3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_3_5 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int sum = 0;
        int lt = 1;
        int count = 0;
        for (int rt = 1 ; rt <= n; rt++) {
            if (sum < n) {
                sum = sum + rt;
            }

            while (sum >= n) {
                if (sum == n && lt < rt) {
                    count++;
                }
                sum = sum - lt;
                lt++;
            }

        }

        System.out.println(count);


    }
}
