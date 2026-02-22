package heeun98.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class m_13 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int count = Integer.parseInt(br.readLine());

        List<ArrayList<Integer>> gr = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            gr.add(new ArrayList<>());
        }

        for (int i = 0; i < count; i++) {
            String s = br.readLine();
            st = new StringTokenizer(s);

            int father = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            gr.get(father).add(child);
            gr.get(child).add(father);
        }

        Queue<Integer> que = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];

        que.add(start);
        visit[start] = true;

        boolean flag = true;
        int distance = 0;
        while (!que.isEmpty()) {

            int size = que.size();

            for (int i = 0; i < size; i++) {
                Integer poll = que.poll();
                if (poll == end) {
                    System.out.println(distance);
                    return;
                }
                ArrayList<Integer> list = gr.get(poll);
                for (int j = 0; j < list.size(); j++) {
                    if (visit[list.get(j)]) continue;
                    que.offer(list.get(j));
                    visit[list.get(j)] = true;
                }
            }

            distance++;
        }


        System.out.println(-1);
    }
}
