package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_251020_1 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        List<ArrayList<Integer>> gr = new ArrayList<>();

        for (int i = 0; i <= input; i++) {
            gr.add(new ArrayList());
        }

        for (int i = 0; i < input - 1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            gr.get(nodeA).add(nodeB);
            gr.get(nodeB).add(nodeA);
        }

        int[] parents = new int[input + 1];
        boolean[] visit = new boolean[input + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;


        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int i = 0; i < gr.get(poll).size(); i++) {
                Integer num = gr.get(poll).get(i);
                if (visit[num]) continue;
                parents[num] = poll;
                visit[num] = true;
                queue.add(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < parents.length; i++) {

            sb.append(parents[i] + "\n");
        }
        System.out.println(sb);



    }
}
