package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_250925 {

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0 , 1, -1};
    public static int n;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());


        int[][] gr = new int[n][n];
        boolean[][] visit = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            char[] charArray = input.toCharArray();
            for (int j = 0; j < n; j++) {
                gr[i][j] = charArray[j] - '0';
            }
        }


        List<Integer> result = new ArrayList<>();
        int count = 0;

        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (gr[i][j] == 1 && !visit[i][j]) {
                    int out = bfs(visit, gr, i, j);
                    result.add(out);
                    count++;
                }
            }
        }

        System.out.println(count);
        result.stream()
                .sorted()
                .forEach(s -> System.out.println(s));
     }

     public static int bfs(boolean[][] visit, int[][] gr, int r ,int c) {

         Queue<int[]> queue = new LinkedList<>();

         int out = 0;
         queue.add(new int[]{r, c});
         visit[r][c] = true;

         while (!queue.isEmpty()) {

             int[] poll = queue.poll();
             out++;
             int cr = poll[0];
             int cc = poll[1];

             for (int i = 0 ; i < 4; i++ ) {
                 int nr = cr + dx[i];
                 int nc =  cc + dy[i];

                 if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                     continue;
                 }

                 if (visit[nr][nc]) {
                     continue;
                 }

                 if (gr[nr][nc] == 0) {
                     continue;
                 }

                 queue.add(new int[]{nr, nc});
                 visit[nr][nc] = true;

             }
         }

         return out;


     }
}
