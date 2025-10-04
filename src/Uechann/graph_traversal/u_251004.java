package Uechann.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 
 * 적록색약 다국어
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	86797	50940	38222	57.459%

문제 10026

적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.

크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 
그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)

예를 들어, 그림이 아래와 같은 경우에

RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)

그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)

둘째 줄부터 N개 줄에는 그림이 주어진다.

출력
적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.

예제 입력 1 
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
예제 출력 1 
4 3
 */

public class u_251004 {

    static char[][] matrix;
    static boolean[][] isVisited_colorblind;
    static boolean[][] isVisited_normal;

    static int[][] div = {
            { 1, 0 },
            { -1, 0 },
            { 0, 1 },
            { 0, -1 }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count_blind = 0, count_normal = 0;

        matrix = new char[n + 1][n + 1];
        isVisited_colorblind = new boolean[n + 1][n + 1];
        isVisited_normal = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            char[] tmp = br.readLine().toCharArray();

            for (int j = 1; j <= n; j++) {
                matrix[i][j] = tmp[j - 1];
            }
        }

        // R, G, B로 나뉘는 영역이 몇개 인지 판단
        // 적록색약이 있으면 R, G를 같은 색으로 판단한다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (!isVisited_colorblind[i][j]) {
                    bfs_colorblind(new int[] { i, j }, n);
                    count_blind++;
                }

                if (!isVisited_normal[i][j]) {
                    bfs_normal(new int[] { i, j }, n);
                    count_normal++;
                }

            }
        }

        System.out.println(count_normal + " " + count_blind);
    }

    static void bfs_colorblind(int[] start, int n) {
        Queue<int[]> q = new LinkedList<>();

        q.add(start);
        isVisited_colorblind[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] u = q.poll();

            int r = u[0];
            int c = u[1];
            char color = matrix[r][c];

            for (int[] d : div) {
                int nr = r + d[0];
                int nc = c + d[1];

                // 범위에 맞는지 // 갈 수 있는지 // 방문 했는지
                if (nr > 0 && nr <= n && nc >= 0 && nc <= n) {

                    if (!isVisited_colorblind[nr][nc]) {

                        char nextColor = matrix[nr][nc];
                        if (color == nextColor || (color == 'R' && nextColor == 'G')
                                || (color == 'G' && nextColor == 'R')) {

                            q.add(new int[] { nr, nc });
                            isVisited_colorblind[nr][nc] = true;
                        }
                    }
                }
            }
        }
    }

    static void bfs_normal(int[] start, int n) {
        Queue<int[]> q = new LinkedList<>();

        q.add(start);
        isVisited_normal[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] u = q.poll();

            int r = u[0];
            int c = u[1];
            char color = matrix[r][c];

            for (int[] d : div) {
                int nr = r + d[0];
                int nc = c + d[1];

                // 범위에 맞는지 // 갈 수 있는지 // 방문 했는지
                if (nr > 0 && nr <= n && nc >= 0 && nc <= n) {

                    if (!isVisited_normal[nr][nc]) {

                        char nextColor = matrix[nr][nc];
                        if (color == nextColor) {

                            q.add(new int[] { nr, nc });
                            isVisited_normal[nr][nc] = true;
                        }
                    }
                }
            }
        }
    }
}
