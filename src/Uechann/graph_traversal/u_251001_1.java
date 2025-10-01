package Uechann.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 연결 요소의 개수
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
3 초	512 MB	171759	78653	51233	42.490%

문제 11724
방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
(1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

출력
첫째 줄에 연결 요소의 개수를 출력한다.

예제 입력 1 
6 5
1 2
2 5
5 1
3 4
4 6
예제 출력 1 
2
예제 입력 2 
6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3
예제 출력 2 
1
 */

public class u_251001_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        // 인접 리스트
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean[] isVisited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                bfs(i, isVisited, list);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void bfs(int start, boolean[] isVisited, List<List<Integer>> list) {

        Queue<Integer> q = new LinkedList<>();
        isVisited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();

            list.get(u).stream()
                    .filter(v -> !isVisited[v])
                    .forEach(v -> {
                        isVisited[v] = true;
                        q.add(v);
                    });
        }

    }
}
