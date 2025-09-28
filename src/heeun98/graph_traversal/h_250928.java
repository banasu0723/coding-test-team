package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class h_250928 {

    private static int[] distance = new int[100001];
    private static boolean[] visit = new boolean[100001];


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == end) {
                break;
            }

            for (int i = 0; i < 3; i++) {
                int n = 0;
                if (i == 0) {
                    n = poll + 1;
                }

                if (i == 1) {
                    n = poll - 1;
                }

                if (i == 2) {
                    n = poll * 2;
                }

                if (n > 100000 || n < 0) {
                    continue;
                }

                if (visit[n]) {
                    continue;
                }

                distance[n] = distance[poll] + 1;
                visit[n] = true;
                queue.add(n);
            }

        }

        System.out.println(distance[end]);


    }
}
