package heeun98.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_t_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<ArrayList<Integer>> gr = new ArrayList<>();


        for (int i = 0; i <= n; i++) {
            gr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            gr.get(start).add(end);
            gr.get(end).add(start);
        }


        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        Queue<Integer> que = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];

        que.offer(start);


        while (!que.isEmpty()) {

            int size = que.size();

            for (int i = 0; i < size; i++) {

                Integer poll = que.poll();
                ArrayList<Integer> list = gr.get(poll);

                for (int j = 0; j < list.size(); j++) {
                    Integer num = list.get(j);

                    if (visit[num]) continue;
                    visit[num] = true;
                    que.offer(num);
                }

            }

        }

        if (visit[end]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }




    }
}
