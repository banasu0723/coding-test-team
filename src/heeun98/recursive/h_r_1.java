package heeun98.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class h_r_1 {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        recursive(n, n);

    }

    private static void recursive(int idx, int n) {
        if (idx == 1) {
            System.out.print(idx + " ");
            return;
        }
        recursive(idx - 1, n);
        System.out.print(idx + " ");
    }
}
