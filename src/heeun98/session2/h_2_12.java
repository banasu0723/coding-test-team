package heeun98.session2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_2_12 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());



        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[][] arr = new int[m][n];


        for (int i = 0;i < m; i++) {
            String s = br.readLine();
            StringTokenizer st1 = new StringTokenizer(s);
            for (int j = 0;j < n; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        int pi = 0;
        int pj = 0;
        int answer = 0;

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                int count = 0;
                for (int k = 0; k < m; k++) {
                    for (int u = 0; u < n; u++) {

                        if (arr[k][u] == i) {
                            pi = u;
                        }

                        if (arr[k][u] == j) {
                            pj = u;
                        }
                    }
                    if (pi > pj) {
                        count++;
                    }
                }

                if (count == m) {
                    answer++;
                }
            }
        }

        System.out.println(answer);







    }
}
