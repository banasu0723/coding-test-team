package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class h_10 {


    static int[][] arr;
    static boolean[][] visit;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int count = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[7][7];
        visit = new boolean[7][7];

        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        bfs(0, 0);
    }


    static void bfs(int r, int c) {

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r, c});
        visit[r][c] = true;
        int L = 0;

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                int[] poll = que.poll();

                if (poll[0] == 6 && poll[1] == 6) {
                    System.out.println(L);
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int nr = poll[0] + dr[j];
                    int nc = poll[1] + dc[j];

                    if (nr < 0 || nc < 0 || nr >= 7 || nc >= 7) continue;
                    if (visit[nr][nc]) continue;
                    if (arr[nr][nc] == 1) continue;

                    visit[nr][nc] = true;
                    que.offer(new int[]{nr, nc});
                }
            }
            L++;
        }

        System.out.println(-1);
    }




}
