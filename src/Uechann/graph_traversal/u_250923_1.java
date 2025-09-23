package Uechann.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 문제 2178
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

예제 입력 1 
4 6
101111
101010
101011
111011
예제 출력 1 
15

예제 입력 2 
4 6
110110
110110
111111
111101
예제 출력 2 
9

예제 입력 3 
2 25
1011101110111011101110111
1110111011101110111011101
예제 출력 3 
38

예제 입력 4 
7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
 */

public class u_250923_1 {
    // 인접 행렬
    static int[][] matrix;
    static boolean[][] isVisted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] dir = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        matrix = new int[n + 1][m + 1];
        isVisted = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            int[] row = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 1; j <= m; j++) {
                matrix[i][j] = row[j - 1];
            }
        }

        // BFS 너비우선 탐색
        Queue<int[]> q = new LinkedList<>();

        // (1,1) 지점부터 시작
        isVisted[1][1] = true;
        q.add(new int[] { 1, 1, 1 });

        while (!q.isEmpty()) {
            int[] u = q.poll();
            int x = u[0];
            int y = u[1];
            int dis = u[2];

            // 4 방향으로 갈 수 있는 경우의 수
            // (x+1, y) (x-1, y), (x, y+1), (x, y-1)
            // -> dx, dy 이용해서 4방향 반복문으로 처리
            // 그 중에서 갈 수 있는지 검사
            // 그 중에서 방문 했는지 검사
            // 현재 distance값에서 +1 해서 생성후 q에 enqueue

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                int next[] = new int[] { nx, ny, 0 };

                if (nx > 0 && nx <= n && ny > 0 && ny <= m) {
                    if (!isVisted[nx][ny] && matrix[nx][ny] == 1) {
                        next[2] = dis + 1;

                        if (nx == n && ny == m) {
                            System.out.println(next[2]);
                            return;
                        }
                        isVisted[nx][ny] = true;
                        q.offer(next);
                    }
                }
            }

        }
    }

}
