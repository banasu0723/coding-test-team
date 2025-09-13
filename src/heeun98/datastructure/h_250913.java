package heeun98.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class h_250913 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            if (line.startsWith("push_front")) {
                String[] split = line.split(" ");
                int num = Integer.parseInt(split[1]);
                queue.addFirst(num);
                continue;
            }

            if (line.startsWith("push_back")) {
                String[] split = line.split(" ");
                int num = Integer.parseInt(split[1]);
                queue.addLast(num);
                continue;
            }

            if (line.equals("pop_front")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.pollFirst()+ "\n");
                }
                continue;
            }


            if (line.equals("pop_back")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.pollLast()+ "\n");
                }
                continue;
            }

            if (line.equals("size")) {
                sb.append(queue.size() + "\n");
                continue;
            }

            if (line.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
                continue;
            }

            if (line.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.peekFirst() + "\n");
                }
                continue;
            }

            if (line.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.peekLast() + "\n");
                }
            }


        }

        System.out.println(sb);
    }
}
