package heeun98.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_251220 {

    static int[] co = new int[6];
    static int resultX;
    static int resultY;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);


        for (int i = 0; i < 6; i++) {
            co[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = -999; i <= 999; i++) {
            dfs(i, -999);
        }
        System.out.println(resultX + " " + resultY);
    }

    public static void dfs(int x, int y) {

        if (y == 1000) return;
        if (check(x, y))  {
            resultX = x;
            resultY = y;
        }
        dfs(x, y + 1);
    }

    private static boolean check(int x, int y) {

        if (co[0] * x + co[1] * y == co[2] &&
                co[3] * x + co[4] * y == co[5]) {
            return true;
        }

        return false;
    }


}
