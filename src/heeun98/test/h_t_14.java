package heeun98.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_t_14 {


    static boolean[] con;
    static int n;
    static int size;

    static int sum1 = 0;
    static int sum2 = 0;
    static int[][] gr;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        con = new boolean[n];
        gr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for (int j = 0; j < n; j++) {
                gr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


       size = n / 2;


        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int idx, int v) {

        if (v == size) {
            int sum1 = 0;
            int sum2  = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (con[i] && con[j]) {
                        sum1 += gr[i][j] + gr[j][i];
                    }
                    if (!con[i] && !con[j]) {
                        sum2 += gr[i][j] + gr[j][i];
                    }
                }
            }

            answer = Math.min(Math.abs(sum1 - sum2), answer);
            return;

        }

        for (int i = idx; i < n; i++) {
            con[i] = true;
            dfs(i + 1, v + 1);
            con[i] = false;
        }
    }
}
