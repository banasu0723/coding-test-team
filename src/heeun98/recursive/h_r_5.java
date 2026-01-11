package heeun98.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class h_r_5 {

    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dfs(1);
    }

    private static void dfs(int current) {

        if (current == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (arr[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }
        arr[current] = 1;
        dfs(current + 1);

        arr[current] = 0;
        dfs(current + 1);
    }
}
