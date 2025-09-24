package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_250924 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int size = Integer.parseInt(br.readLine());

        List<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= input; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < size ; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }

        Queue<Integer> queue = new LinkedList<>();

        boolean[] visit = new boolean[input + 1];
        queue.add(1);
        visit[1] = true;
        int count = 0;

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();
            ArrayList<Integer> integers = list.get(poll);

            for (int i = 0; i < integers.size(); i++) {
                Integer num = integers.get(i);

                if (visit[num]) {
                    continue;
                }
                queue.add(num);
                visit[num] = true;
                count++;
            }
        }

        System.out.println(count);


    }
}
