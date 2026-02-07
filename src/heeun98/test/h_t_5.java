package heeun98.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class h_t_5 {

    static int[] env;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());


        Edge[] edges = new Edge[e];
        env = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            env[i] = i;
        }


        for (int i = 0; i < e; i++) {

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Edge edge = new Edge(start, end, weight);
            edges[i] = edge;
        }

        Arrays.sort(edges, (o1, o2) -> {
            return o1.weight - o2.weight;
        });

        int sum = 0;

        for (int i = 0; i < e; i++) {
            Edge edge = edges[i];
            int start = edge.start;
            int end = edge.end;
            if (find(start) == find(end)) continue;

            union(start, end);
            sum += edge.weight;
        }

        System.out.println(sum);
    }

    public static int find(int v) {
        if (env[v] == v) return v;
        return env[v] = find(env[v]);
    }

    public static void union(int v1, int v2) {
        int a = find(v1);
        int b = find(v2);

        if (a != b) env[a] = b;
    }


    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
