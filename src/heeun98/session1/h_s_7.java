package heeun98.session1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class h_s_7 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String lower = input.toLowerCase();

        char[] arr = lower.toCharArray();
        int len = arr.length;

        for (int i = 0; i < arr.length / 2; i++) {

            if (arr[i] != arr[len - 1 - i]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

    }
}
