package banasu0723.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1260번 DFS와 BFS
public class b_250922 {
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수 (개별 요소)
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수 (연결선)
        int v = Integer.parseInt(st.nextToken()); // 정점의 번호 (시작점)

        // 그래프 초기화
        graph = new int[n+1][n+1]; // 1부터 시작

        // 간선 입력
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1; // 양방향 간선
        }

        visited = new boolean[n+1];
        dfs(v);

        System.out.println();

        visited = new boolean[n+1];
        bfs(v);

    }

    private static void dfs(int v) {
        visited[v] = true;  // 현재 정점 방문 체크
        System.out.print(v + " ");

        for(int i = 1; i < graph.length; i++){
            if (graph[v][i] == 1 && visited[i] == false){
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v); // 시작 정점 넣기
        visited[v] = true; // 방문 체크
        System.out.print(v + " ");

        while(!q.isEmpty()){ // 큐가 빌때까지 반복
            int tmp = q.poll(); // 큐에서 꺼냄
            for(int i = 1; i < graph.length; i++){
                if (graph[tmp][i] == 1 && visited[i]==false){
                    q.add(i); // 새로운 인접 노드 큐에 넣음
                    visited[i] = true; // 방문 체크
                    System.out.print(i + " ");
                }
            }
        }

    }
}