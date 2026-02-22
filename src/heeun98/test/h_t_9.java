package heeun98.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_t_9 {

    static boolean[][] visit;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int n;
    static int[][] gr;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        gr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            gr[i] = Arrays.stream(s.split(""))
                    .mapToInt(str -> Integer.parseInt(str))
                    .toArray();
        }


        int count = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (gr[i][j] == 1 && !visit[i][j]) {
                    int bfs = bfs(i, j);
                    result.add(bfs);
                    count++;
                }
            }
        }

        System.out.println(count);
        result.stream().sorted().forEach(a -> System.out.println(a));
    }

    static int bfs(int r, int c) {

        Queue<int[]> que = new LinkedList<>();
        visit[r][c] = true;
        que.offer(new int[]{r, c});
        int count = 0;

        while (!que.isEmpty()) {

            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] poll = que.poll();
                count++;

                for (int j = 0; j < 4; j++) {
                    int nr = poll[0] + dr[j];
                    int nc = poll[1] + dc[j];
                    
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    if (gr[nr][nc] == 0) continue;
                    if (visit[nr][nc]) continue;

                    visit[nr][nc] = true;
                    que.offer(new int[]{nr, nc});
                }
            }
        }

        return count;

    }
}
