package heeun98.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_251209 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            int k = Integer.parseInt(st.nextToken());

            if (k == 0)  return;

            int[] lotto = new int[k];
            for (int i = 0; i < k; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
            }


            bfs(0, lotto, 0, "");
            System.out.println();

        }
    }



    static void bfs(int idx, int[] lotto, int count, String print) {

        if (count == 6) {
            System.out.print(print);
            System.out.println();
        }

        for (int i = idx; i < lotto.length; i++) {
            bfs(i + 1, lotto, count + 1, print + lotto[i] + " ");
        }

    }
}
