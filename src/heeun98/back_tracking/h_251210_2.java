package heeun98.back_tracking;

import javax.print.attribute.IntegerSyntax;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class h_251210_2 {

    static int[] numbers;
    static boolean[] visit;
    static int n;
    static int max = Integer.MIN_VALUE;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        numbers = new int[n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, "");
        System.out.println(max);

    }


    static void dfs(int count, String number) {


        if (count == n) {
            String[] num = number.split(" ");
            int sum = 0;
            for (int i = 0; i < num.length - 1; i++) {
                sum += Math.abs(Integer.parseInt(num[i]) - Integer.parseInt(num[i + 1]));
                max = Math.max(max, sum);
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            dfs(count + 1, number + numbers[i] + " ");
            visit[i] = false;
        }


    }
}

