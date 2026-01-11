package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_1_2 {

    static int[] result;
    static int[] arr;
    static int n;
    static int sum;
    static boolean flag;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        result = new int[n];
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        dfs(0);
        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }

    static void dfs(int v) {
        if (flag) return;
        if (v == n) {
            int sum1 = 0;
            for (int i = 0; i < n; i++) {
                if (result[i] == 1) {
                    sum1 += arr[i];
                }
            }
            if (sum1 * 2 == sum) {
                flag = true;
            }
            return;
        }
        result[v] = 1;
        dfs(v + 1);

        result[v] = 0;
        dfs(v + 1);
    }
}
