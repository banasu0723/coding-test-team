package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_251206 {

    static int[] count;
    static char[] op = {'+', '-', '*', '%'};
    static int n;
    static int[] number;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());

        number = new int[n];

        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());


        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int complex = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());

        count = new int[]{plus, minus, complex, div};


        dfs(number[0], 0);

        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int result, int idx) {
        if (idx == n - 1) {
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (count[i] == 0) continue;
            count[i] = count[i] - 1;
            if (i == 0) {
                dfs(result + number[idx + 1], idx + 1);
                count[i] = count[i] + 1;
                continue;
            }
            if (i == 1) {
                dfs(result - number[idx + 1], idx + 1);
                count[i] = count[i] + 1;
                continue;
            }
            if (i == 2) {
                dfs(result * number[idx + 1], idx + 1);
                count[i] = count[i] + 1;
                continue;
            }
            if (i == 3) {
                dfs(result / number[idx + 1], idx + 1);
                count[i] = count[i] + 1;
                continue;
            }
        }

    }
}
