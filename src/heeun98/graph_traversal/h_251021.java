package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class h_251021 {

    private static int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    private static int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {


            int size = Integer.parseInt(br.readLine());
            int[][] gr = new int[size][size];
            boolean[][] visit = new boolean[size][size];
            int[][] distance = new int[size][size];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};


            if (start[0] == end[0] && start[1] == end[1]) {
                System.out.println(0);
                continue;
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start[0], start[1]});
            visit[start[0]][start[1]] = true;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int cr = poll[0];
                int cc = poll[1];

                for (int j = 0; j < 8; j++) {

                    int nc = cc + dx[j];
                    int nr = cr + dy[j];

                    if (nc < 0 || nc >= size || nr < 0 || nr >= size) continue;

                    if (visit[nr][nc]) continue;

                    distance[nr][nc] = distance[cr][cc] + 1;
                    queue.add(new int[]{nr, nc});
                    visit[nr][nc] = true;

                }
            }

            System.out.println(distance[end[0]][end[1]]);
            }
        }



}
