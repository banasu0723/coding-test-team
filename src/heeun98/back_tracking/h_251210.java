package heeun98.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class h_251210 {

    public static int l;
    public static String vowels = "aeiou";
    public static int result = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[] arr = new String[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);


        dfs(0, arr, 0 , "");

    }


    static void dfs(int idx, String[] arr, int count, String com) {

        if (count == l) {
            char[] password = com.toCharArray();
            int vowelCount = 0;
            int consonantCount = 0;

            for (char c : password) {
                if (vowels.indexOf(c) >= 0) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
            if (vowelCount >= 1 && consonantCount >= 2) {
                System.out.println(com);
            }
            return;
        }

        // < 7
        for (int i = idx; i < arr.length; i++) {
            dfs(i + 1, arr, count + 1, com + arr[i]);
        }


    }
}
