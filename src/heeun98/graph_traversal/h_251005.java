package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_251005 {

    static int n;
    static int m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<int[]> virus;
    static List<int[]> empty;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] gr = new int[n][m];

        virus = new ArrayList<>();
        empty = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);

            for (int j = 0 ; j < m; j++) {
                gr[i][j] = Integer.parseInt(st.nextToken());

                if (gr[i][j] == 0) {
                    empty.add(new int[]{i, j});
                }

                if (gr[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        int E = empty.size();
        int result = 0;

        for (int i = 0; i < E; i++) {
            for (int j = i + 1; j < E; j++) {
                for (int k = j + 1; k < E; k++) {

                    int[] a = empty.get(i);
                    int[] b = empty.get(j);
                    int[] c = empty.get(k);

                    gr[a[0]][a[1]] = 1;
                    gr[b[0]][b[1]] = 1;
                    gr[c[0]][c[1]] = 1;

                    result = Math.max(result, bfs(gr));


                    gr[a[0]][a[1]] = 0;
                    gr[b[0]][b[1]] = 0;
                    gr[c[0]][c[1]] = 0;

                }
            }
        }

        System.out.println(result);


    }

    public static int bfs(int[][] gr) {

        boolean[][] visit = new boolean[n][m];//new 로 생성하면 지역변수여도 초기화 된다.
        Queue<int[]> queue = new LinkedList<>();


        for (int[] v : virus) {
            queue.add(v);
            visit[v[0]][v[1]] = true;
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];

            for (int i = 0; i  < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];


                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }


                if (gr[nr][nc] == 1) {
                    continue;
                }

                if (visit[nr][nc]) {
                    continue;
                }

                queue.add(new int[]{nr, nc});
                visit[nr][nc] = true;

            }

        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (gr[i][j] == 0 && !visit[i][j]) {
                    count++;
                }
            }
        }


        return count;

    }
}
