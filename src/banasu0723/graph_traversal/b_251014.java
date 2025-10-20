package banasu0723.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_251014 {
    // 1697번 숨바꼭질
    static int N, K;             // 수빈 위치, 동생 위치
    static int[] visited = new int[100001]; // 방문 시간 기록용 (최대 100000까지 가능)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1; // 시작점 (1초부터 세기 때문에 0 대신 1로 표시)

        while (!q.isEmpty()) {
            int current = q.poll();

            // 도착하면 걸린 시간 -1 리턴
            if (current == K) {
                return visited[current] - 1;
            }

            // 이동 가능한 세 가지 경우
            int[] next = {current - 1, current + 1, current * 2};

            for (int nx : next) {
                // 범위를 벗어나지 않고 아직 방문 안 했다면
                if (nx >= 0 && nx <= 100000 && visited[nx] == 0) {
                    visited[nx] = visited[current] + 1; // 현재 위치 + 1초
                    q.add(nx); // 다음 위치 큐에 추가
                }
            }
        }
        return -1; // 도달 불가한 경우 (이 문제에서는 발생하지 않음)
    }
}
