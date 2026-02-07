package heeun98.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class h_t_3 {

    static int[] distance;
    static ArrayList<ArrayList<Edge>> gr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        gr = new ArrayList<>();
        distance = new int[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < n + 1; i++) {
            gr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            gr.get(start).add(new Edge(end, weight));
        }


        solution(1);


        System.out.println(Arrays.toString(distance));
    }

    public static void solution(int node) {

        PriorityQueue<Edge> pq = new PriorityQueue<>((l1, l2) -> {
            return l1.cost - l2.cost;
        });

        pq.offer(new Edge(node, 0));
        distance[node] = 0;

        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int now = poll.end;
            int nowCost = poll.cost;

            if (nowCost > distance[now]) continue;

            for (Edge ob : gr.get(now)) {
                if (distance[ob.end] > nowCost + ob.cost) {
                    distance[ob.end] = nowCost + ob.cost;
                    pq.offer(new Edge(ob.end, nowCost + ob.cost));
                }
            }
        }

    }


    static class Edge {
        int end;
        int cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}

/**
 6 9
 1 2 12
 1 3 4
 2 1 2
 2 3 5
 2 5 5
 3 4 5
 4 2 2
 4 5 5
 6 4 5
 */
