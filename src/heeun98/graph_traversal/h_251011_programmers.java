package heeun98.graph_traversal;
import java.util.*;

public class h_251011_programmers {


    public int solution(int[] priorities, int location) {

        int answer = 0;

        int want = priorities[location];

        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pr =
                new PriorityQueue<>(Collections.reverseOrder());// 기본 최소힙 구조

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i});
            pr.add(priorities[i]);
        }

        int count = 1;
        int out = 0;

        while (!queue.isEmpty()) {

            int[] pos = queue.poll();

            if (pos[0] < pr.peek()) {
                queue.add(pos);
                continue;
            }

            if (pos[1] == location) {
                out = count;
            }

            pr.poll();
            count++;

        }

        return out;

    }
}
