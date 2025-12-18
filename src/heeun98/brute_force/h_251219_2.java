package heeun98.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class h_251219_2 {

    static List<int[]> schedule;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        schedule = new ArrayList<>();



        for (int i = 0; i < n ; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int days = Integer.parseInt(st.nextToken());
            int benefits = Integer.parseInt(st.nextToken());

            schedule.add(new int[]{days, benefits});
        }


        dfs(0, 0);

        System.out.println(result);

    }


    static void dfs(int idx, int sum) {

        if (idx <= schedule.size()) {
            result = Math.max(result, sum);
        }


        for (int i = idx; i < schedule.size(); i++) {
            int[] sc = schedule.get(i);
            int days = sc[0];
            int price = sc[1];
            dfs(i + days, sum + price);
        }
    }
}
