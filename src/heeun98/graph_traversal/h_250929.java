package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_250929 {

    private static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        List<ArrayList<Integer>> gr = new ArrayList<>();


        visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            gr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            gr.get(start).add(end);
            gr.get(end).add(start);
        }

        int result = 0;

        for (int i = 1; i <= n ; i++) {

            if (!visit[i]) {

                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visit[i] = true;

                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();

                    for (int j = 0; j < gr.get(poll).size(); j++) {

                        if (visit[gr.get(poll).get(j)]) {
                            continue;
                        }

                        queue.add(gr.get(poll).get(j));
                        visit[gr.get(poll).get(j)] = true;
                    }
                }
                result++;
            }
        }

        System.out.println(result);
    }
}
