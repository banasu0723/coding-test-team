package Uechann.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 
 * 최단경로
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	252065	80034	41489	26.958%
문제 1753
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.

입력
첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 
둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다. 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 이
는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다. 
서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

출력
첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.

예제 입력 1 
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
예제 출력 1 
0
2
3
7
INF
 */

public class u_251003 {

    static List<List<int[]>> list;
    static boolean[] isVisited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        // 초기화
        list = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }
        isVisited = new boolean[v + 1];
        distance = new int[v + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            list.get(start).add(new int[] { end, dis });
        }

        daijstra(k);

        for (int i = 1; i <= v; i++) {
            sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n"); 
        }

        System.out.println(sb);
    }

    public static void daijstra(int start) {

        // 우선순위 큐의 정렬 기준을 정해준다. 2번째 값, 즉, 거리를 기준으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.add(new int[] { start, 0 });
        isVisited[start] = true;
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0];

            isVisited[vertex] = true;

            list.get(current[0]).stream()
                    .filter(v -> !isVisited[v[0]])
                    .forEach(v -> {
                        if (distance[v[0]] > distance[current[0]] + v[1]) {
                            distance[v[0]] = distance[current[0]] + v[1];
                            pq.add(new int[] { v[0], distance[v[0]] });
                        }
                    });
        }
    }
}
