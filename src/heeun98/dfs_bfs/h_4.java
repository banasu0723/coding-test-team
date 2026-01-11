package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_4 {

    static int target;
    static int n;
    static int answer = Integer.MAX_VALUE;
    static int[] memo = new int[501];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 동전 종류

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 501; i++) {
            memo[i] = Integer.MAX_VALUE;
        }


        int[] arr = new int[n];

        for (int i = 0;i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        target = Integer.parseInt(br.readLine());// 거스름돈

        dfs(0, 0,  arr);



        System.out.println(memo[target]);

    }

    static void dfs(int L, int sum, int[] arr) {

        if (sum > target) return;

        if (memo[sum] <= L) return; // 더 이상 스택 프레임을 쌓을 필요가 없음
        else memo[sum] = L;

        if (sum == target) return;

        for (int i = 0; i < n; i++) {
            dfs(L + 1, sum + arr[i], arr);
        }
    }


}
