package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class h_5 {


    static int n;
    static int m;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs( 0, "");


        Collections.sort(result);

        System.out.println(result);

    }

    static void dfs(int L, String num) {
        if (L == m) {
            result.add(num);
            return;
        }

        for (int i = 1; i <= n; i++) {
            dfs(L + 1, num + i + " ");
        }
    }


}
