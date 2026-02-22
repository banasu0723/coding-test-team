package heeun98.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class h_t_10 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] coin = new int[n];

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        int goal = Integer.parseInt(br.readLine());

        int[] dy = new int[goal + 1];

        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for (int i = 0 ; i < coin.length; i++) {
            int price = coin[i];
            for (int j = price; j <= goal; j++) {
                dy[j] = Math.min(dy[j], dy[j - price] + 1);
            }
        }

        System.out.println(dy[goal]);
    }
}
