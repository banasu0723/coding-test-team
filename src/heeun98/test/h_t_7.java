package heeun98.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_t_7 {

    static int answer = Integer.MAX_VALUE;
    static int price;
    static int[][] gr;
    static boolean[][] visit;
    static int r;
    static int c;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0,  0, 1, -1};


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        gr = new int[r][c];
        visit = new boolean[r][c];


        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int sc = Integer.parseInt(st.nextToken());
            int sr = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());

            for (int j = sr; j < er; j++) {
                for (int e = sc; e < ec; e++) {
                    gr[j][e] = 1;
                }
            }
        }

        int cnt = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (gr[i][j] == 0 && !visit[i][j]) {
                    int area = bfs(i, j);
                    result.add(area);
                    cnt++;
                }
            }

        }

        Collections.sort(result);

        System.out.println(cnt);
        result.stream()
                .forEach(i -> System.out.print(i + " "));

    }


    static int bfs(int cr, int cc) {


        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{cr, cc});
        visit[cr][cc] = true;

        int area = 0;

        while (!que.isEmpty()) {

            int size = que.size();

            for (int i = 0; i < size; i++) {

                int[] poll = que.poll();
                area++;
                for (int j = 0; j < 4; j++) {

                    int nr = poll[0] + dr[j];
                    int nc = poll[1] + dc[j];
                    if (nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                    if (visit[nr][nc]) continue;
                    if (gr[nr][nc] == 1) continue;


                    visit[nr][nc] = true;
                    gr[nr][nc] = 1;
                    que.offer(new int[]{nr, nc});
                }

            }
        }

        return area;
    }
}
