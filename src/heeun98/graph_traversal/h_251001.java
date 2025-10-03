package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_251001 {

    static int[] distance;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        distance = new int[v + 1];
        boolean[] visit = new boolean[v + 1];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        int start = Integer.parseInt(br.readLine());

        List<ArrayList<Node>> gr = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            gr.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            String read = br.readLine();
            st = new StringTokenizer(read);
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            gr.get(nodeA).add(new Node(nodeB, weight));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.weight - o2.weight;
        });


        pq.add(new Node(start,0));
        distance[start] = 0;


        while(!pq.isEmpty()) {
            Node poll = pq.poll();
            int now = poll.index;
            ArrayList<Node> nodes = gr.get(now);

            for (int i = 0; i < nodes.size(); i++) {

                int end = nodes.get(i).index;
                int weight = nodes.get(i).weight;

                if (distance[end] < distance[now] + weight) {
                    continue;
                }

                if (distance[end] > distance[now] + weight) {
                    distance[end] = distance[now] + weight;
                    pq.add(new Node(end, distance[end]));
                }
            }
        }

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(distance[i]);
        }

    }


    static class Node {
        int index;
        int weight;

        public Node(int end, int weight) {
            this.index = end;
            this.weight = weight;
        }

    }
}
