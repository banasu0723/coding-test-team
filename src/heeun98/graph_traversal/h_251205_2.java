package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class h_251205_2 {
    static boolean[] visit;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] gr = new int[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            gr[i] = i + 1;
        }


        bfs(gr, n, m, "", 0);

        Collections.sort(result);


        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    static void bfs(int[] gr, int n, int m, String str, int count) {

        if (count == m) {
            result.add(str);
            return;
        }
        for (int i = 0; i < n; i++) {

            if (visit[i]) continue;

            visit[i] = true;
            bfs(gr, n, m, str + gr[i] + " ", count + 1);
            visit[i] = false;
        }

    }

}
