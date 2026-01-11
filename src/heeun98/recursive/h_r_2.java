package heeun98.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class h_r_2 {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        recursive(n);
    }

    private static void recursive(int n) {

        if (n == 1) {
            System.out.print(n);
            return;
        }
        recursive(n / 2);
        System.out.print(n % 2);
    }
}
