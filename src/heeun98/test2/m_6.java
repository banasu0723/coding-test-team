package heeun98.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class m_6 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        String s = br.readLine();
        st = new StringTokenizer(s);

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = k - 1;
        int sum = 0;
        for (int i = lt; i <= rt; i++) {
            sum += arr[i];
        }
        int max = sum;

        while (rt < n - 1) {

            sum -= arr[lt];
            lt++;
            rt++;
            sum += arr[rt];
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }
}
