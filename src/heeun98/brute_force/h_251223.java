package heeun98.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class h_251223 {

    static boolean[] broken = new boolean[10];
    static boolean[] visit = new boolean[10];
    static int target;
    static int result = Integer.MAX_VALUE;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int len = input.length();
        target = Integer.parseInt(input);

        int brokenCount = Integer.parseInt(br.readLine());

        if (brokenCount > 0) {
            st = new StringTokenizer(br.readLine());
        }

        for (int i = 0; i < brokenCount; i++) {
            int num = Integer.parseInt(st.nextToken());
            broken[num] = true;
        }

        int useCount = 10 - brokenCount;
        for (int i = 1; i <= len + 1; i++) {
            dfs("", i);
        }


        System.out.println(Math.min(result, Math.abs(100 - target)));
    }

    static void dfs(String number, int length) {

        if (number.length() == length) {
            int createNumber = Integer.parseInt(number);
            result = Math.min(result, Math.abs(target - createNumber) + length);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (broken[i]) continue;

            dfs(number + i, length);
        }
    }
}
