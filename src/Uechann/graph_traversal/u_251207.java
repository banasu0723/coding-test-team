package Uechann.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
치킨 배달 15686
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	512 MB	113556	57274	34729	47.235%
문제
크기가 N×N인 도시가 있다. 도시는 1×1크기의 칸으로 나누어져 있다. 
도시의 각 칸은 빈 칸, 치킨집, 집 중 하나이다. 도시의 칸은 (r, c)와 같은 형태로 나타내고, 
r행 c열 또는 위에서부터 r번째 칸, 왼쪽에서부터 c번째 칸을 의미한다. r과 c는 1부터 시작한다.

이 도시에 사는 사람들은 치킨을 매우 좋아한다. 따라서, 사람들은 "치킨 거리"라는 말을 주로 사용한다. 
치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다. 
즉, 치킨 거리는 집을 기준으로 정해지며, 각각의 집은 치킨 거리를 가지고 있다. 
도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.

임의의 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|로 구한다.

예를 들어, 아래와 같은 지도를 갖는 도시를 살펴보자.

0 2 0 1 0
1 0 1 0 0
0 0 0 0 0
0 0 0 1 1
0 0 0 1 2
0은 빈 칸, 1은 집, 2는 치킨집이다.

(2, 1)에 있는 집과 (1, 2)에 있는 치킨집과의 거리는 |2-1| + |1-2| = 2, 
(5, 5)에 있는 치킨집과의 거리는 |2-5| + |1-5| = 7이다. 
따라서, (2, 1)에 있는 집의 치킨 거리는 2이다.

(5, 4)에 있는 집과 (1, 2)에 있는 치킨집과의 거리는 |5-1| + |4-2| = 6, 
(5, 5)에 있는 치킨집과의 거리는 |5-5| + |4-5| = 1이다. 
따라서, (5, 4)에 있는 집의 치킨 거리는 1이다.

이 도시에 있는 치킨집은 모두 같은 프랜차이즈이다. 
프렌차이즈 본사에서는 수익을 증가시키기 위해 일부 치킨집을 폐업시키려고 한다. 
오랜 연구 끝에 이 도시에서 가장 수익을 많이 낼 수 있는  치킨집의 개수는 최대 M개라는 사실을 알아내었다.

도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다. 
어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 13)이 주어진다.

둘째 줄부터 N개의 줄에는 도시의 정보가 주어진다.

도시의 정보는 0, 1, 2로 이루어져 있고, 0은 빈 칸, 1은 집, 2는 치킨집을 의미한다. ]
집의 개수는 2N개를 넘지 않으며, 적어도 1개는 존재한다. 
치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다.

출력
첫째 줄에 폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값을 출력한다.

예제 입력 1 
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
예제 출력 1 
5
예제 입력 2 
5 2
0 2 0 1 0
1 0 1 0 0
0 0 0 0 0
2 0 0 1 1
2 2 0 1 2
예제 출력 2 
10
예제 입력 3 
5 1
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
예제 출력 3 
11
예제 입력 4 
5 1
1 2 0 2 1
1 2 0 2 1
1 2 0 2 1
1 2 0 2 1
1 2 0 2 1
*/

public class u_251207 {

    public static boolean[][] isVisited;
    public static int totalChickenDistance = Integer.MAX_VALUE;
    public static List<int[]> chickenHouse = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(" ");
        int[][] graph;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1][N + 1];

        // 그래프 생성
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 치킨집 리스트 생성
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == 2) {
                    chickenHouse.add(new int[] { i, j });
                }
            }
        }

        // 최대 치킨집이 M개일때, M개 가능한 치킨집 조합 생성
        List<List<int[]>> chickenCombination = generateChickenCombination(0, M);

        // 어떤 치킨집을 M개 남겼을 때, 도시의 치킨 거리가 최소가 되는지 업데이트
        // 각 치킨집 조합 마다 bfs로 도시의 치킨 거리 계산 후 최소 값 갱신
        for (List<int[]> combination : chickenCombination) {

            int totalDistance = 0;
            int[][] graphCopy = Arrays.stream(graph)
                    .map(a -> Arrays.copyOf(a, N + 1))
                    .toArray(int[][]::new);

            // System.out.println("copyGraph");
            // for (int i = 1; i <= N; i++) {
            //     for (int j = 1; j <= N; j++) {
            //         System.out.print(graphCopy[i][j]);
            //     }
            // }

            for (int[] a : chickenHouse) {
                if (!combination.contains(a)) {
                    graphCopy[a[0]][a[1]] = 0;
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graphCopy[i][j] == 1) {
                        int chickenDistance = bfs(i, j, N, graphCopy);
                        // System.out.println(i + ", " + j + ": 치킨 거리 :" + chickenDistance);
                        totalDistance += chickenDistance;
                    }
                }
            }

            // System.out.println("totalDistance: " + totalDistance);
            if (totalDistance < totalChickenDistance) {
                totalChickenDistance = totalDistance;
            }
        }

        // 도시의 치킨 거리의 최솟값 출력
        System.out.println(totalChickenDistance);
    }

    private static int bfs(int r, int c, int N, int[][] graph) {

        int[][] div = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };

        int distance = 0;

        initializeIsVisited(N);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c, 0 });
        isVisited[r][c] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            distance = current[2];

            if (graph[row][col] == 2) {
                return distance;
            }

            // 다음 4방향 순회하면 queue에 거리 집어 넣기
            for (int[] d : div) {
                int nr = row + d[0];
                int nc = col + d[1];

                // 범위의 맞는지 검사, 방문 했는지, 갈 수 있는지
                if (nr > 0 && nr <= N && nc > 0 && nc <= N && !isVisited[nr][nc]) {
                    q.add(new int[] { nr, nc, distance + 1 });
                    isVisited[nr][nc] = true;
                }
            }
        }

        return distance;
    }

    private static void initializeIsVisited(int N) {
        for (int i = 0; i <= N; i++) {
            Arrays.fill(isVisited[i], false);
        }
    }

    private static List<List<int[]>> generateChickenCombination(int start, int M) {

        List<List<int[]>> chickenComblination = new ArrayList<>();
        boolean[] chickenIsVisited = new boolean[chickenHouse.size()];

        for (int[] chicken : chickenHouse) {
            // System.out.println(chicken[0] + ", " + chicken[1]);
        }
        combination(start, M, chickenIsVisited, chickenComblination);

        return chickenComblination;
    }

    private static void combination(int start, int M,
            boolean[] chickenIsVisted,
            List<List<int[]>> chickenComblination) {

        if (M == 0) {
            List<int[]> combination = new ArrayList<>();
            for (int i = 0; i < chickenHouse.size(); i++) {
                if (chickenIsVisted[i]) {
                    // System.out.println("조합에 1개 추가: " + chickenHouse.get(i)[0] + ", " + chickenHouse.get(i)[1]);
                    combination.add(chickenHouse.get(i));
                }
            }
            // System.out.println("조합 생성: " + combination);
            chickenComblination.add(combination);
            return;
        }

        for (int i = start; i < chickenHouse.size(); i++) {
            chickenIsVisted[i] = true;
            combination(i + 1, M - 1, chickenIsVisted, chickenComblination);
            chickenIsVisted[i] = false;
        }

    }
}
