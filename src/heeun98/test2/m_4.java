package heeun98.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class m_4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] gr = new int[m][n];
        int[][] score = new int[n + 1][n + 1];

        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                gr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int student = gr[i][j];
                for (int k = j + 1; k < n; k++) {
                    int num = gr[i][k];
                    score[student][num]++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[0].length; j++) {
                if (score[i][j] == m) {
                    count++;
                }
            }
        }


        System.out.println(count);
    }
}
