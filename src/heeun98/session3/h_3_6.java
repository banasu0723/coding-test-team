package heeun98.session3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_3_6 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        int[] arr = new int[n];

        String input = br.readLine();
        st = new StringTokenizer(input);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int count = 0;
        int answer = Integer.MIN_VALUE;
        int len = 0;

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                count++;
            }
            while (count > k) {
                if (arr[lt] == 0) {
                    count--;
                }
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }

        System.out.println(answer);


    }
}
