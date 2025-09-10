package heeun98.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class h_250906 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0;i < n; i++) {

            String line = br.readLine();

            if (line.contains("push")) {
                StringTokenizer st = new StringTokenizer(line);
                String s = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                que.offer(num);
                continue;
            }


            if (line.equals("pop")) {

                if (que.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(que.poll() + "\n");
                }
                continue;
            }


            if (line.equals("size")) {
                sb.append(que.size() + "\n");
                continue;
            }

            if (line.equals("empty")) {

                if (que.isEmpty()) {
                    sb.append("1\n");

                } else {
                    sb.append("0\n");
                }
                continue;
            }

            if (line.equals("front")) {
                if (que.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(que.peek() + "\n");
                }
                continue;
            }

            if (line.equals("back")) {

                if (que.isEmpty()) {
                    sb.append("-1\n");
                } else {

                    List<Integer> result = que.stream()
                            .collect(Collectors.toList());
                    Integer i1 = result.get(result.size() - 1);
                    sb.append(i1 + "\n");
                }
                continue;
            }
        }

        System.out.println(sb);
    }
}
