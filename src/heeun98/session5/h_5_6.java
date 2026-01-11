package heeun98.session5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class h_5_6 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);
        Queue<Integer> que = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= n; i++) {
            que.add(i);
        }

        int count = 0;

        while (que.size() > 1) {

            Integer poll = que.poll();
            count++;

            if (count != k) {
                que.add(poll);
            } else {
                count = 0;
            }
        }

        System.out.println(que.poll());
    }
}
