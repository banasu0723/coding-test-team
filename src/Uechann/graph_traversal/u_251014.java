package Uechann.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 나이트의 이동 다국어
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	75532	41415	30773	53.610%

문제 7562
체스판 위에 한 나이트가 놓여져 있다. 나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 나이트가 이동하려고 하는 칸이 주어진다. 나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?


입력
입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.

각 테스트 케이스는 세 줄로 이루어져 있다. 첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 체스판의 크기는 l × l이다. 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다. 
둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.

출력
각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.

예제 입력 1 
3
8
0 0
7 0
100
0 0
30 50
10
1 1
1 1
예제 출력 1 
5
28
0
 */

public class u_251014 {

    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {

            // 체스판의 크기
            int n = Integer.parseInt(br.readLine());
            isVisited = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            sb.append(bfs(sr, sc, er, ec, n)).append("\n");

            isVisited = null;
        }

        System.out.println(sb);
    }

    public static int bfs(int sr, int sc, int er, int ec, int n) {

        int[][] div = {
                { 1, 2 },
                { 1, -2 },
                { -1, 2 },
                { -1, -2 },
                { 2, 1 },
                { 2, -1 },
                { -2, 1 },
                { -2, -1 }
        };

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { sr, sc, 0 });
        isVisited[sr][sc] = true;

        int minCount = Integer.MAX_VALUE;
        while (!q.isEmpty()) {

            int[] u = q.poll();
            int ur = u[0];
            int uc = u[1];
            int count = u[2];

            if (ur == er && uc == ec && count < minCount) {
                minCount = count;
                break;
            }

            for (int[] d : div) {
                int nr = ur + d[0];
                int nc = uc + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (!isVisited[nr][nc]) {
                        q.add(new int[] { nr, nc, count + 1 });
                        isVisited[nr][nc] = true;
                    }
                }

            }

        }

        return minCount;
    }
}
