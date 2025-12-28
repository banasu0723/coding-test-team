package heeun98.session1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class h_s_12 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        String s = input.replaceAll("#", "1")
                .replaceAll("\\*", "0");

        int start = 0;
        int end = start + 7;


        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.substring(start, end);
            start += 7;
            end += 7;
        }


        String answer = "";

        for (String string : arr) {
            int num = Integer.parseInt(string, 2);
            char result = (char) num;
            answer += result;
        }

        System.out.println(answer);


    }
}
