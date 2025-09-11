package heeun98.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_250910 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line);


        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder("<");

        while (!queue.isEmpty()) {


            for (int i = 0; i < k - 1; i++) {
                Integer poll = queue.poll();
                queue.offer(poll);
            }
            Integer poll = queue.poll();
            if (queue.size() == 0) {
                sb.append(poll + ">");
                continue;
            }
            sb.append(poll + ", ");
        }


        System.out.println(sb);


    }
}
