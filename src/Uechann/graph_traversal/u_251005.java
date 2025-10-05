package Uechann.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
토마토 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	114929	51482	37650	43.881%

문제 7569

철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.

창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 
보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 
하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다. 
대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 
철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.

토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 
며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

입력
첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H가 주어진다. 
M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이다. 
둘째 줄부터는 가장 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다. 
즉, 둘째 줄부터 N개의 줄에는 하나의 상자에 담긴 토마토의 정보가 주어진다. 각 줄에는 상자 가로줄에 들어있는 토마토들의 상태가 M개의 정수로 주어진다. 
정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다. 이러한 N개의 줄이 H번 반복하여 주어진다.

토마토가 하나 이상 있는 경우만 입력으로 주어진다.

출력
여러분은 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.

예제 입력 1 
5 3 1
0 -1 0 0 0
-1 -1 0 1 1
0 0 0 1 1
예제 출력 1 
-1
예제 입력 2 
5 3 2
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 0 0 0 0
예제 출력 2 
4
예제 입력 3 
4 3 2
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
-1 -1 -1 -1
1 1 1 -1
예제 출력 3 
0
 */

public class u_251005 {

    static int[][][] matrix;
    static boolean[][][] isVisited;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        matrix = new int[h + 1][n + 1][m + 1];
        isVisited = new boolean[h + 1][n + 1][m + 1];
        q = new LinkedList<>();

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= m; k++) {
                    matrix[i][j][k] = Integer.parseInt(st.nextToken());

                    if (matrix[i][j][k] == 1) {
                        q.add(new int[] { i, j, k, 0 });
                        // isVisited[i][j][k] = true;
                    }
                }
            }
        }

        System.out.println(bfs(n, m, h));

    }

    public static int bfs(int n, int m, int h) {
        int[][] div = {
                { 1, 0, 0 },
                { -1, 0, 0 },
                { 0, 1, 0 },
                { 0, -1, 0 },
                { 0, 0, 1 },
                { 0, 0, -1 }
        };

        int maxdepth = 0;

        while (!q.isEmpty()) {

            int[] u = q.poll();
            int he = u[0];
            int r = u[1];
            int c = u[2];
            int depth = u[3];
            // System.out.println("현재: " + he + ", " + r + ", " + c + "");

            if (depth > maxdepth)
                maxdepth = depth;

            for (int[] d : div) {
                int nh = he + d[0];
                int nr = r + d[1];
                int nc = c + d[2];

                // 범위에 맞는지 // 익지 않은 토마토 인지 // 방문 했는지
                if (nh > 0 && nh <= h && nr > 0 && nr <= n && nc > 0 && nc <= m) {

                    if (matrix[nh][nr][nc] == 0) {
                        q.add(new int[] { nh, nr, nc, depth + 1 });
                        // isVisited[nh][nr][nc] = true;
                        matrix[nh][nr][nc] = 1;
                        // System.out.println("큐에 추가: " + nh + ", " + nr + ", " + nc + "");
                    }
                }
            }
        }

        if (isFinished(n, m, h)) {
            return maxdepth;
        } else {
            return -1;
        }

    }

    static boolean isFinished(int n, int m, int h) {
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    if (matrix[i][j][k] == 0)
                        return false;
                }
            }
        }

        return true;
    }
}
