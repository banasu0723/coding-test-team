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
 * 연구소
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	512 MB	121511	71248	39990	56.037%

문제 14502
인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.

연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. 

일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.

예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.

2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.

2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.

2 1 0 0 1 1 0
1 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 1 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
바이러스가 퍼진 뒤의 모습은 아래와 같아진다.

2 1 0 0 1 1 2
1 0 1 0 1 2 2
0 1 1 0 1 2 2
0 1 0 0 0 1 2
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.

연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)

둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.

빈 칸의 개수는 3개 이상이다.

출력
첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력한다.

예제 입력 1 
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
예제 출력 1 
27
예제 입력 2 
4 6
0 0 0 0 0 0
1 0 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2
예제 출력 2 
9
예제 입력 3 
8 8
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
예제 출력 3 
3
 */

public class u_251002 {

    static int[][] matrix;
    static boolean[][] isVisited;
    static List<List<int[]>> wallSet;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> q = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        matrix = new int[n + 1][m + 1];
        isVisited = new boolean[n + 1][m + 1];

        List<int[]> zeros = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 1; j <= m; j++) {    

                matrix[i][j] = Integer.parseInt(st.nextToken());

                if (matrix[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (matrix[i][j] == 0) {
                    zeros.add(new int[] { i, j });
                }
            }
        }
        
        wallSet = new ArrayList<>();
        // 먼저 3개 벽을 설치하는 경우의 수를 체크 하고 각각 bfs 후 최대값 갱신
        track(zeros, 0, 3, new ArrayList<>());

        for (List<int[]> wallList : wallSet) {
            // q 를 복사 하는데 그냥 = q 하면 참조를 하게 되어 같이 값이 변하기 때문에
            // 생성자로 새로운 Queue를 만들어 깊은 복사를 한다.
            Queue<int[]> qc = new LinkedList<>(q);
            bfs(wallList, qc, n, m);
        }

        System.out.println(max);
    }

    // 0중에서 1(벽)을 3개를 정하는 모든 경우 안겹치게 체크 set
    public static void track(List<int[]> zeros, int s, int r, List<int[]> current) {

        if (r == 0) {
            wallSet.add(new ArrayList<>(current));
            // System.out.println("벽: " + current);
            return;
        }
        
        for (int i = s; i <= zeros.size() - r; i++) {
            current.add(zeros.get(i));
            track(zeros, i + 1, r - 1, current);
            // 제거 백트래킹
            current.remove(current.size() - 1);
        }
    }

    // 바이러스 전파
    public static void bfs(List<int[]> wallList, Queue<int[]> qc, int n, int m) {

        // System.out.println("바이러스 전파 시작");

        int[][] div = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };

        // 깊은 복사 clone() 함수로 각 행 배열까지 새로 복사
        int[][] mc = new int[matrix.length][];
        for(int i=0; i< matrix.length; i++) {
            mc[i] = matrix[i].clone();
        }

        for (int[] wall : wallList) {
            int row = wall[0];
            int col = wall[1];

            mc[row][col] = 1;
            // System.out.println("벽: " + row + ", " + col);
        }

        for(boolean[] row: isVisited){
            Arrays.fill(row, false);
        }
        while (!qc.isEmpty()) {
            int[] u = qc.poll();
            int r = u[0];
            int c = u[1];
            isVisited[r][c] = true;

            // System.out.println("현재: " + r + ", " + c);

            for (int[] d : div) {
                int nr = r + d[0];
                int nc = c + d[1];

                // 범위에 맞는지 // 갈 수 있는지 // 방문 했는지 //
                if (nr > 0 && nr <= n && nc > 0 && nc <= m) {

                    if (mc[nr][nc] == 0 && !isVisited[nr][nc]) {
                        isVisited[nr][nc] = true;
                        qc.add(new int[] { nr, nc });
                        mc[nr][nc] = 2;

                        // System.out.println("큐에 next 추가 : " + nr + ", " + nc);
                    }
                }
            }

        }

        // 안전지대 계산 후 업데이트
        int count = countsafe(mc, n, m);
        // System.out.println("현재 안전지대 :" + count);
        if(count > max) max = count;
    }

    // 전체 안전지대 계산
    public static int countsafe(int[][] mc, int n, int m) {

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (mc[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
}
