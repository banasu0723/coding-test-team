package heeun98.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class h_251211_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));



        for (int i = 0; i < n; i++) {
            String number = br.readLine();
            int num = Integer.parseInt(number);

            if (num == 0 && maxHeap.isEmpty()) {
                System.out.println(0);
                continue;
            }

            if (num != 0) {
                maxHeap.add(num);
                continue;
            }

            if (num == 0) {
                System.out.println(maxHeap.poll());
            }
        }
    }
}
