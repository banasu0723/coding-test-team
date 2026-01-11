package heeun98.session5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class h_5_7 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String order = br.readLine();
        Queue<Character> que = new LinkedList<>();

        for (char c : order.toCharArray()) {
            que.add(c);
        }

        String schedule = br.readLine();
        Queue<Character> sc = new LinkedList<>();

        for (char c : schedule.toCharArray()) {
            sc.add(c);
        }


        while (!sc.isEmpty()) {
            char poll = sc.poll();
            if (order.contains(String.valueOf(poll))) {
                if (que.peek() != poll) {
                    System.out.println("NO");
                    return;
                }
                que.poll(); // 같을 때
            }
        }


        if (!que.isEmpty()) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
        return;
    }
}
