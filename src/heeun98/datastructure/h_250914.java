package heeun98.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_250914 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int size = Integer.parseInt(st.nextToken());
            int want = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();

            String line = br.readLine();
            st = new StringTokenizer(line);
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            for (int j = 0; j < size; j++) {

                int num = Integer.parseInt(st.nextToken());
                queue.add(new int[]{j, num});
                pq.add(num);
            }

            int count = 1;
            while (!queue.isEmpty()) {

                if (queue.peek()[1] < pq.peek() ) {
                    queue.add(queue.poll());
                    continue;
                }

                int[] poll = queue.poll();
                pq.poll();
                if (poll[0] == want) {
                    System.out.println(count);
                    break;
                }
                count++;
            }

        }


    }
}
