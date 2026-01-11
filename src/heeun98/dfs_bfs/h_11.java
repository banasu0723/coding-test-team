package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class h_11 {


    static int[][] arr;
    static boolean[][] visit;
    static int[][] distance;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int count = 0;
    static int m;
    static int n;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];
        distance = new int[n][m];


        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    que.offer(new int[]{i, j});
                }
            }

        }


        bfs(que);

        boolean flag = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag) System.out.println(-1);
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(distance[i][j], answer);
                }
            }
            System.out.println(answer);
        }
    }


    static void bfs(Queue<int[]> que) {

        while (!que.isEmpty()) {

            int size = que.size();

            for (int i = 0; i < size; i++) {

                int[] poll = que.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = poll[0] + dr[j];
                    int nc = poll[1] + dc[j];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                        continue;
                    }
                    if (arr[nr][nc] == -1 || arr[nr][nc] == 1) continue;

                    arr[nr][nc] = 1;
                    distance[nr][nc] = distance[poll[0]][poll[1]] + 1;
                    que.offer(new int[]{nr, nc});
                }
            }
        }

    }




}
