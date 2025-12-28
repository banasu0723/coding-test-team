package heeun98.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class h_251224 {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0 , 1, -1};
    static List<CCTV> list;
    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;

    static int[][][] dir = {
            {},
            {{0} ,{1}, {2}, {3}},
            {{0, 1}, {2, 3}},
            {{0, 2}, {1, 2}, {3, 1}, {3, 0}},
            {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}},
            {{0, 1, 2, 3}}
    };

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] space = new int[n][m];

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] >= 1 && space[i][j] <= 5) {
                    list.add(new CCTV(i, j, space[i][j]));
                }
            }
        }
        
        
        dfs(0, space);
        System.out.println(answer);

    }

    private static void dfs(int idx, int[][] space) {

        if (idx == list.size()) {
            answer = Math.min(answer, countBlind(space));
            return;
        }

        CCTV cctv = list.get(idx);

        int r = cctv.r;
        int c = cctv.c;

        for (int[] t : dir[cctv.type]) {

            int[][] next = copy(space);

            for (int i : t) {
                watch(i, next, r, c);
            }
            dfs(idx + 1, next);

        }
    }

    private static void watch(int dir, int[][] next, int r, int c) {

        int nr = r + dr[dir];
        int nc = c + dc[dir];

        while (nr >= 0 && nr < n && nc >= 0 && nc < m) {

            if (next[nr][nc] == 6) break;

            if (next[nr][nc] == 0) {
                next[nr][nc] = -1;
            }

            nr += dr[dir];
            nc += dc[dir];
        }

    }


    static int countBlind(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    private static int[][] copy(int[][] space) {
        int[][] arr = new int[n][m];

        for (int i = 0; i < n ;i++) {
            arr[i] = space[i].clone();
        }

        return arr;
    }

    static class CCTV{

        private int r;
        private int c;
        private int type;


        public CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }


        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getType() {
            return type;
        }
    }
}
