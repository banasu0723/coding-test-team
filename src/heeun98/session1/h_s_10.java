package heeun98.session1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class h_s_10 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        String s = st.nextToken();
        String next = st.nextToken();
        char t = next.charAt(0);


        char[] arr = s.toCharArray();

        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (i - j >= 0 && arr[i - j] == t || i + j < arr.length && arr[i + j] == t) {
                    result.add(String.valueOf(j));
                    break;
                }
            }
        }

        String print = String.join(" ", result);

        System.out.println(print);
    }
}
