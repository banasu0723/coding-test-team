package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class h_6 {


    static int n;
    static int m;
    static int[] arr;
    static boolean[] visit;
    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        arr = new int[n];
        visit = new boolean[n];
        result = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i< n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

    }

    static void dfs(int v) {
        if (v == m) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            result[v] = arr[i];
            dfs(v + 1);
            visit[i] = false;
        }
    }


}
