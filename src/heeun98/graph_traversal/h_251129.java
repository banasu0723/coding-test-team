package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class h_251129 {

    static int[][] result;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();


        int n = Integer.parseInt(br.readLine());


        int[][] arr = new int[n][n];
        result = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            visit = new boolean[n];
            dfs(list, i, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n ;i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }


    public static void dfs(List<ArrayList<Integer>> list, int start, int realStart) {


        for (int i = 0; i < list.get(start).size(); i++) {
            int node = list.get(start).get(i);
            if (visit[node]) continue;
            result[realStart][node] = 1;
            visit[node] = true;
            dfs(list, node, realStart);
        }
    }
}
