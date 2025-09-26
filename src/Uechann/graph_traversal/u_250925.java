package Uechann.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
 * 문제 2667
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 

대각선상에 집이 있는 경우는 연결된 것이 아니다. 

<그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 
각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.


입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

예제 입력 1 
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

예제 출력 1 
3
7
8
9
 */

public class u_250925 {

    static int[][] matrix;
    static boolean[][] isVisted;
    static List<Integer> result = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        matrix = new int[n + 1][n + 1];
        isVisted = new boolean[n + 1][n + 1];

        // 1-based
        for (int i = 1; i <= n; i++) {
            int[] row = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 1; j <= n; j++) {
                matrix[i][j] = row[j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i][j] == 1 && !isVisted[i][j]) {
                    // System.out.println("새로운 bfs " + i + ", " + j);
                    bfs(new int[] { i, j, 1 });
                }
            }
        }

        System.out.println(result.size());
        result.stream()
                .sorted()
                .forEach(System.out::println);
    }

    // bfs 함수
    public static void bfs(int[] start) {

        int[][] dir = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };
        int max = 1;

        // start 점으로부터 bfs 탐색
        Queue<int[]> q = new LinkedList<>();

        isVisted[start[0]][start[1]] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int[] u = q.poll();

            int x = u[0];
            int y = u[1];
            int count = u[2];

            // 4방향으로 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                // 이동할 수 있는지 
                // 범위 맞는지
                // 방문 했는지
                if (nx > 0 && nx <= n && ny > 0 && ny <= n && !isVisted[nx][ny] && matrix[nx][ny] == 1) {
                    isVisted[nx][ny] = true;
                    q.add(new int[] { nx, ny, count + 1 });
                    max++;
                    // System.out.println(nx + ", " + ny + "q에 추가" + " max:" + max);
                }
            }

        }

        result.add(max);
    }
}
