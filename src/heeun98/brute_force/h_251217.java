package heeun98.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class h_251217 {

    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] len = new int[9];
        for (int i = 0; i < 9; i++) {
            len[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(len);
        dfs(0, len, 0, 0);
    }


    public static void dfs(int idx, int[] len, int count, int sum) {

        if (sum > 100 || count > 7) {
            return;
        }
        if (sum == 100 && count == 7) {
            result.stream()
                    .sorted(((o1, o2) -> Integer.compare(o1,o2)))
                    .forEach(i -> System.out.println(i));
            System.exit(0);
        }

        for (int i = idx; i < 9; i++) {
            result.add(Integer.valueOf(len[i]));
            dfs(i + 1, len, count + 1, sum + len[i]);
            result.remove(result.size() - 1);
        }
    }
}
