package heeun98.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class h_t_1 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        //abcde - > 5 - 2 = 3
        isSequenceDigit(s);


    }

    private static boolean isSequenceDigit(String s) {
        for (int i = 0; i < s.length() - 2; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);


            if (!Character.isDigit(a) || !Character.isDigit(b) || !Character.isDigit(c)) {
                continue;
            }

            int x = a - '0';
            int y = b - '0';
            int z = c - '0';

            if ((x + 1) % 10 == y && (y + 1) % 10 == z) return false;
        }

        return true;
    }
}
