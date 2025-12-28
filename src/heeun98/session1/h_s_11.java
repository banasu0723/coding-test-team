package heeun98.session1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class h_s_11 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();


        char[] arr = input.toCharArray();
        int count = 1;
        String answer = "";
        for (int i = 1; i <= arr.length; i++) {

            if (i == arr.length) {
                answer += arr[i - 1];

                if (count > 1) {
                    answer += count;
                }
                continue;
            }

            if (arr[i - 1] == arr[i]) {
                count++;
                continue;
            }

            if (arr[i - 1] != arr[i]){
                answer += arr[i - 1];
                if (count > 1) {
                    answer += count;
                }
                count = 1;
            }
        }
        System.out.println(answer);

    }
}
