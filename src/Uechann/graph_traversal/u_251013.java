package Uechann.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 섬의 개수 다국어
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	82971	42892	30817	50.538%

문제 4963
정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.

한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 

두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 
각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.

둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.

입력의 마지막 줄에는 0이 두 개 주어진다.

출력
각 테스트 케이스에 대해서, 섬의 개수를 출력한다.

예제 입력 1 
1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0
예제 출력 1 
0
1
1
3
1
9
 */

public class u_251013 {

    static int[][] matrix;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            int count = 0;
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            matrix = new int[h + 1][w + 1];
            isVisited = new boolean[h + 1][w + 1];

            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= w; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (!isVisited[i][j] && matrix[i][j] == 1) {
                        // System.out.println("현재" + i + ", " + j);
                        bfs(i, j, h, w);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");

            matrix = null;
            isVisited = null;
        }

        System.out.println(sb);

    }

    public static void bfs(int r, int c, int h, int w) {
        // System.out.println("bfs 시작");

        int[][] div = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 },
                { 1, 1 },
                { 1, -1 },
                { -1, 1 },
                { -1, -1 }
        };

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { r, c });
        isVisited[r][c] = true;

        while (!q.isEmpty()) {

            int[] u = q.poll();

            int ur = u[0];
            int uc = u[1];
            // System.out.println("현재: "+ ur + ", " + uc);

            for (int[] d : div) {
                int nr = ur + d[0];
                int nc = uc + d[1];

                if (nr > 0 && nr <= h && nc > 0 && nc <= w) {
                    if (!isVisited[nr][nc] && matrix[nr][nc] == 1) {

                        // System.out.println("q에 추가 " + nr + ", " + nc);
                        q.add(new int[] { nr, nc });
                        isVisited[nr][nc] = true;
                    }
                }


            }
        }
    }
}
