package heeun98.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class h_g_4 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int maxDay = 0;

        Lecture[] lectures = new Lecture[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            int price = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            maxDay = Math.max(maxDay, day);

            Lecture lecture = new Lecture(price, day);
            lectures[i] = lecture;
        }


        Arrays.sort(lectures, (l1, l2) -> {
            return -1 * (l1.day - l2.day);
        });


        int sum = 0;



        for (int i = 0; i < lectures.length; i++) {

            if (maxDay > lectures[i].day) {
                sum += pq.poll();
                maxDay = lectures[i].day;
            }

            pq.offer(lectures[i].price);
        }

        sum += pq.poll();
        maxDay--;

        while(maxDay > 0 && !pq.isEmpty()) {
            sum += pq.poll();
            maxDay--;
        }


        System.out.println(sum);
    }

    static class Lecture {
        int price;
        int day;

        public Lecture(int price, int day) {
            this.price = price;
            this.day = day;
        }

    }
}
