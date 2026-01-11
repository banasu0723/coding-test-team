package heeun98.session5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_5_8 {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        String input = br.readLine();
        st = new StringTokenizer(input);

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> que = new LinkedList<>();
        PriorityQueue<Integer> rank = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            que.add(new int[]{i, arr[i]});
            rank.add(arr[i]);
        }

        int count = 0;
        int maxNum = rank.peek();
        while (!que.isEmpty()) {

            int[] poll = que.poll();
            int value = poll[1];
            int idx = poll[0];

            if (maxNum > value) { // 위험도가 큰사람이 존재할 경우
                que.add(poll);
                continue;
            }

            // 내 차례인데 위험도가 나보다 큰사람이 없을때 -> 순서증가, 우선순위 큐에서 하나제거
            count++;
            rank.poll();
            maxNum = rank.peek();
            if (idx == k) {
                System.out.println(count);
                return;
            }
        }

    }
}
