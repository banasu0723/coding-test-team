package heeun98.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class h_r_7 {

    static int[] dx = {1, -1, 5};
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int current = Integer.parseInt(st.nextToken());
        int cow = Integer.parseInt(st.nextToken());
        visit = new boolean[10001];


        int result = bfs(current, cow);
        System.out.println(result);
    }

    private static int bfs(int current, int cow) {

        Queue<Integer> que = new LinkedList<>();
        que.offer(current);
        visit[current] = true;
        int distance = 0;
        while (!que.isEmpty()) {

            int len = que.size();
            System.out.print(distance + " : ");
            for (int i = 0; i < len; i++) {

                Integer poll = que.poll();
                System.out.print(poll + ",");
                if (poll == cow) return distance;

                for (int j = 0; j < dx.length; j++) {
                    int newP = poll + dx[j];
                    if (newP < 1 || newP > 10000) continue;
                    if (visit[newP]) continue;

                    visit[newP] = true;
                    que.offer(newP);
                }
            }

            distance++;
            System.out.println();
        }
        return -1;
    }
}
