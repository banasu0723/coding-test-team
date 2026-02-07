package heeun98.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_t_4 {


    static int[] env;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        env = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            env[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            union(p1, p2);
        }

        String s = br.readLine();
        st = new StringTokenizer(s);

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (find(a) != find(b)) System.out.println("NO");
        else System.out.println("YES");
    }


    static void union(int p1, int p2) {

        int pm1 = find(p1);
        int pm2 = find(p2);

        if (pm1 != pm2) env[pm1] = pm2;
    }


    static int find(int num) {

        if (env[num] == num) return num;

        return env[num] = find(env[num]);
    }
}
