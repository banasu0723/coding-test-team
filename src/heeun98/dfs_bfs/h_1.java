package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_1 {
    static int n;
    static int[] ch;
    static int[] arr;
    static int total;
    static boolean flag = false;
    static String answer = "NO";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);


        arr = new int[n];
        ch = new int[n];
        total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int v) {

        if (flag) return;

        if (v == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) {
                    sum = sum + arr[i];
                }
            }
            if (sum * 2== total) {
                answer = "YES";
                flag = true;
            }
            return; // 요구사항 거짓일때 return 해서 다음거 수행
        }

        ch[v] = 1;
        dfs(v + 1);
        ch[v] = 0;
        dfs(v + 1);
    }
}
