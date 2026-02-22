package heeun98.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class m_2 {


    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int n,l,p;
    static boolean[][] visit;
    static int[][] gr;
    static List<Pair> xy = new ArrayList<>();
    static boolean move = false;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);


        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        gr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);
            for (int j = 0; j < n; j++) {
                gr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int days = 0;
        while (true) {

            visit = new boolean[n][n];
            move = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (!visit[i][j]) {
                        xy = new ArrayList<>();
                        bfs(i, j);
                    }
                }
            }

            if (!move) break;
            days++;
        }
        System.out.println(days);

    }

    static void bfs(int startR, int startC) {

        Queue<Pair> que = new LinkedList<>();
        visit[startR][startC] = true;
        que.add(new Pair(startR, startC));
        int sum = gr[startR][startC];
        xy.add(new Pair(startR, startC));

        while (!que.isEmpty()) {

            int size = que.size();

            for (int i = 0; i < size; i++) {

                Pair poll = que.poll();
                int currentR = poll.x;
                int currentC = poll.y;

                for (int j = 0; j < 4; j++) {

                    int nr = currentR + dr[j];
                    int nc = currentC + dc[j];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    if (visit[nr][nc]) continue;
                    if (Math.abs(gr[nr][nc] - gr[currentR][currentC]) >= l &&
                            Math.abs(gr[nr][nc] - gr[currentR][currentC]) <= p) {


                        que.add(new Pair(nr, nc));
                        visit[nr][nc] = true;
                        xy.add(new Pair(nr, nc));
                        sum += gr[nr][nc];
                        move = true;
                    }

                }

            }

        }

        if (!move) return;

        int size = xy.size();

        for (Pair pair : xy) {
            int x = pair.x;
            int y = pair.y;
            gr[x][y] = sum / size;
        }





    }

    public static class Pair {
        int x;
        int y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    

}

