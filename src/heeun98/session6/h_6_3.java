package heeun98.session6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_6_3 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pr.add(arr[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i - 1] != pr.poll()) {
                System.out.print(i + " ");
            }
        }


    }
}
