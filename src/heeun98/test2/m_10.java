package heeun98.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class m_10 {

    static int max = 0;
    static Set<Integer> set = new HashSet<>();
    static int realMax;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(0, 1, "");
    }

    static void dfs(int v, int idx, String answer) {

        if (v == m) {
            System.out.println(answer.trim());
            return;
        }
        for (int i = idx; i <= n ; i++) {
            dfs(v + 1, i, answer +" " +  i);
        }
    }
}
