package heeun98.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_251211 {

    static int[] sour;
    static int[] bitter;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        sour = new int[n];
        bitter = new int[n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        bfs(0, 0, 1, 0);

        System.out.println(result);
    }


    static void bfs(int idx, int count, int sourCom, int bitterSum) {
        if (count >= 1) {
            result = Math.min(result, Math.abs(sourCom - bitterSum));
        }
        for (int i = idx; i < sour.length; i++) {
            bfs(i + 1, count + 1, sourCom * sour[i], bitterSum + bitter[i]);
        }
    }
}
