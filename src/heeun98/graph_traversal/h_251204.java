package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class h_251204 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int[] degree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            degree[end]++;
        }


        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                que.add(i);
            }
        }


        while (!que.isEmpty()) {

            Integer poll = que.poll();
            System.out.print(poll + " ");
            for (Integer end : graph.get(poll)) {
                degree[end]--;
                if (degree[end] == 0) {
                    que.add(end);
                }
            }
        }

    }
}
