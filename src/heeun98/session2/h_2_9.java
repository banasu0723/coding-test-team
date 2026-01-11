package heeun98.session2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class h_2_9 {



    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] pos = new int[n][n];


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for (int j = 0; j < n; j++) {
                pos[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = Arrays.stream(pos[i])
                    .sum();
            answer = Math.max(sum, answer);
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += pos[j][i];
            }

            answer = Math.max(answer, sum);
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0;i < n; i++) {
            sum1 += pos[i][i];
            sum2 += pos[n - 1 - i][i];
        }
        answer = Math.max(Math.max(sum2, sum1), answer);


        System.out.println(answer);

    }


}
