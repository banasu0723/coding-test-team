package heeun98.session1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class h_s_8 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String lower = input.toLowerCase();


        String s = lower.replaceAll("[^a-z]", "");

        StringBuilder reverse = new StringBuilder(s).reverse();

        if (reverse.toString().equals(s)) {
            System.out.println("YES");
            return;
        }

        System.out.println("NO");

    }
}
