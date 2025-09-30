package Uechann.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 숨바꼭질 1697
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	300086	91232	58233	26.833%

문제 1697
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순
간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

예제 입력 1 
5 17
예제 출력 1 
4
 */

public class u_250930_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] d = { 1, -1, 2 };
        
        int min = Integer.MAX_VALUE;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // 너비 우선 탐색
        // 갈 수 있는 선택지 +1, -1, *2
        
        boolean[] isVisited = new boolean[100001];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { n, 0 });
        isVisited[n] = true;

        while (!q.isEmpty()) {
            int[] u = q.poll();
            int current = u[0];
            int time = u[1];

            if (current == k && time < min) {
                min = time;
            }

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 2) {
                    next = current * d[i];
                } else {
                    next = current + d[i];
                }

                if (next >= 0 && next <= 100000 && !isVisited[next]) {
                    isVisited[next] = true;
                    q.add(new int[]{next, time + 1});
                }
            }
        }


        System.out.println(min);
    }
}
