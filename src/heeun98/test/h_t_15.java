package heeun98.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_t_15 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        String input = br.readLine();
        st = new StringTokenizer(input);

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] gr = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < m; j++) {
                gr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int count = 0;
        while (true) {



            if (!visit[row][col]) {
                visit[row][col] = true;
                count++;
            }

            boolean isClean = false;
            for (int i = 0; i < 4; i++) {

                d = (d + 3) % 4;

                int nr = row + dr[d];
                int nc = col + dc[d];


                if (!visit[nr][nc] && gr[nr][nc] == 0) {
                    row = nr;
                    col = nc;
                    isClean = true;
                    break;
                }
            }

            if (!isClean) {

                int nr = row - dr[d];
                int nc = col - dc[d];

                if (gr[nr][nc] == 0) {
                    row = nr;
                    col = nc;
                    continue;
                }
                break;

            }

        }


        System.out.println(count);



    }
}
