package heeun98.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class h_r_10 {

    static int[][] pos;
    static boolean[] visit;
    static int n;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visit= new boolean[n + 1];
        pos = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pos[start][end] = 1;
        }


        visit[1] = true;
        dfs(1, "1 ");
    }


    static void dfs(int start, String p) {

        if (start == n) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i < pos[start].length; i++) {

            if (visit[i]) continue;
            if (pos[start][i] == 1) { // 연결 지점
                visit[i] = true;
                dfs(i, p + i + " ");
                visit[i] = false;
            }
        }
    }
}

/**
 5 9
 1 2
 1 3
 1 4
 2 1
 2 3
 2 5
 3 4
 4 2
 4 5
 */
