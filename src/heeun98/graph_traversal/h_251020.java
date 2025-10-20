package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class h_251020 {


    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] gr= new int[m][n][h];
        int[][][] distance= new int[m][n][h];
        boolean[][][] visit= new boolean[m][n][h];



        Queue<int[]> queue = new LinkedList<>();


        int total = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                String input = br.readLine();
                st = new StringTokenizer(input);
                for (int k = 0; k < m; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 0) {
                        total++;
                    }
                    if (num == 1) {
                        queue.add(new int[]{k,j,i});
                        visit[k][j][i] = true;
                    }
                    gr[k][j][i] = num;

                }
            }
        }

        if (total == 0) {
            System.out.println(0);
            return;
        }

        int days = 0;
        int max = 0;
        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            int cc = poll[0];
            int cr = poll[1];
            int ch = poll[2];

            for (int i = 0; i < 6; i++) {
                int nc = cc + dx[i];
                int nr = cr + dy[i];
                int nh = ch + dh[i];

                if (nc < 0 || nc >= m || nr < 0 || nr >= n || nh < 0 || nh >= h) {
                    continue;
                }

                if (visit[nc][nr][nh]) {
                    continue;
                }

                if (gr[nc][nr][nh] != 0) {
                    continue;
                }

                queue.add(new int[]{nc, nr, nh});
                distance[nc][nr][nh] = distance[cc][cr][ch] + 1;
                max = Math.max(max, distance[nc][nr][nh]);
                visit[nc][nr][nh] = true;
                total--;
            }

        }

        if (total == 0) {
            System.out.println(max);
        } else {
            System.out.println(-1);
        }


    }
}
