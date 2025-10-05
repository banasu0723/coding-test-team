package banasu0723.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 7576번 토마토
public class b_251005 {
    static int M, N; // 가로, 세로
    static int[][] box;
    static Queue<int[]> q = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];

        // 입력 받기및 익은 토마토 큐에 다 넣기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    // 익은 토마토가 BFS 시작점 , 이미 1로 표시도이ㅓ있으므로 큐에 넣기
                    q.add(new int[]{i,j});
                }
            }
        }

        bfs();

        // 결과 계산
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) { // 아직 익지 않은 토마토가 있다면
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, box[i][j]);
            }
        }

        // 이미 익은 토마토가 1이었으므로, 최종 일수는 최대값-1
        System.out.println(result - 1);


    }

    // 이미 익은 곳에서 동시에 퍼져나감
    private static void bfs(){
        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for(int i = 0; i < 4; i++){
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                // 범위 안에 있고, 아직 안익었으면 0
                if(next_x >= 0 && next_y >= 0 && next_x < N && next_y < M && box[next_x][next_y] == 0){
                    box[next_x][next_y] = box[x][y] + 1; // 며칠째에 익는지를 저장(거리 개념)
                    q.add(new int[]{next_x, next_y}); // 새로 익은 토마토 추가
                }
            }
        }
    }
}