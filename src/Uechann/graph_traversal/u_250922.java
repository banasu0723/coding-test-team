package Uechann.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 문제 1260
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

예제 입력 1 
4 5 1
1 2
1 3
1 4
2 4
3 4
예제 출력 1 
1 2 4 3
1 2 3 4
 */

public class u_250922 {

    // 인접 행렬
    static boolean[][] matrix;
    static boolean[] flag;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        matrix = new boolean[n + 1][n + 1];
        flag = new boolean[n + 1];

        int start = 0, end = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            matrix[start][end] = true;
            matrix[end][start] = true;
        }
        dfs(v);
        sb.append("\n");
        Arrays.fill(flag, false);
        bfs(v);
        System.out.println(sb);
    }

    public static void dfs(int start) {
        if (flag[start])
            return;

        flag[start] = true;
        sb.append(start).append(" ");

        for (int i = 1; i < flag.length; i++) {
            if (matrix[start][i] && !flag[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append(u).append(" ");
            flag[u] = true;
            start = u;

            for (int i = 1; i < flag.length; i++) {
                if (matrix[start][i] && !flag[i] && !q.contains(i)) {
                    q.add(i);
                    System.out.println(i + "추가");
                }
            }
        }
    }
}
