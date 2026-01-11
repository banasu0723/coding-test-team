package heeun98.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class h_r_3 {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(dfs(n));
    }

    private static int dfs(int n) {

        if (n == 1) {
            return n;
        }
        return n * dfs(n - 1);
    }
}
