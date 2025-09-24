package heeun98.graph_traversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_250922 {

    static boolean[] visit;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];

        List<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0 ; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            ArrayList<Integer> starts = list.get(start);
            ArrayList<Integer> integers = list.get(end);

            starts.add(end);
            integers.add(start);
        }
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> sorts = list.get(i);
            sorts.sort((o1, o2) -> o1 - o2);
        }

        dfs(list, visit, v);

        for (int i = 0; i <= n; i++) {
            visit[i] = false;
        }
        System.out.println();

        bfs(list,visit, v);

    }

    static void dfs(List<ArrayList<Integer>> list , boolean[] visit, int start) {

        System.out.print(start + " ");
        visit[start] = true;
        ArrayList<Integer> node = list.get(start);

        for (int i = 0; i < node.size(); i++) {
            Integer n = node.get(i);
            if (visit[n] == true) {
                continue;
            }

            dfs(list,visit,n);
        }

    }

    static void bfs(List<ArrayList<Integer>> list , boolean[] visit, int start) {

        System.out.print(start + " ");
        Queue<Integer> queue  = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();

            for (int j = 0 ; j < list.get(poll).size(); j++) {
                if (visit[list.get(poll).get(j)] == true)  continue;
                visit[list.get(poll).get(j)] = true;
                System.out.print(list.get(poll).get(j) + " ");
                queue.add(list.get(poll).get(j));
            }
        }

    }
}
