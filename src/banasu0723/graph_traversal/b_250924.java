package banasu0723.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2606 바이러스 dfs + 인접행렬
public class b_250924 {

    static int n; // 컴퓨터 수
    static int m; // 네트워크 상에서 연결되어있는 컴퓨터 수
    static int[][] graph; // 인접 행렬
    static boolean[] visited; //방문 여부
    static int cnt = 0; //감염된 컴퓨터 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1]; // 1부터 시작
        visited = new boolean[n+1];

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] =1;
            graph[b][a] = 1;

        }

        dfs(1);

        System.out.println(cnt - 1); // 자기 자신 제외

    }

    private static void dfs(int v){
        visited[v] = true;
        cnt++;

        for(int i = 1; i <= n ; i++){
            if(graph[v][i] == 1 && !visited[i]){ // 연결되어있고 아직 방문 안했으면
                dfs(i); // i 번노드로 이동해서 계속 탐색
            }
        }
    }
}