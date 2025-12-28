package heeun98.session1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class h_s_5 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        char[] arr = input.toCharArray();

        int lt = 0;
        int rt = arr.length - 1;

        while (lt < rt) {

            if (!Character.isAlphabetic(arr[lt])) {
                lt++;
                continue;
            }

            if (!Character.isAlphabetic(arr[rt])) {
                rt--;
                continue;
            }
            char tmp = arr[lt];
            arr[lt] = arr[rt];
            arr[rt] = tmp;
            lt++;
            rt--;
        }
        System.out.println(String.valueOf(arr));
    }
}
