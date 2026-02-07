package heeun98.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class h_t_6 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stock[] stocks = new Stock[n];
        int[] dy = new int[n];


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int area = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Stock stock = new Stock(area, height, weight);
            stocks[i] = stock;
        }

        Arrays.sort(stocks, (o1, o2) -> {
            return o2.area - o1.area;
        });


        dy[0] = stocks[0].height;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (stocks[i].weight > stocks[j].weight) {
                    continue;
                }
                max = Math.max(max, dy[j]);
            }
            dy[i] = max + stocks[i].height;
        }

        int max = Arrays.stream(dy)
                .max()
                .getAsInt();

        System.out.println(max);

    }

    static class Stock {
        int area;
        int height;
        int weight;

        public Stock(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }
    }
}
