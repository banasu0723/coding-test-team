package heeun98.graph_traversal;
import java.util.*;

public class h_251008_1_programmers {


    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                days[i] = (100 - progresses[i]) / speeds[i];
            } else {
                days[i] = (100 - progresses[i]) / speeds[i] + 1;
            }
        }

        System.out.print(Arrays.toString(days));


        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(days[idx]);
        idx++;
        List<Integer> result = new ArrayList<>();
        int max = days[0];

        while (idx < days.length) {
            if (!stack.isEmpty() && max < days[idx]) {
                result.add(stack.size());
                stack.clear();
                stack.push(days[idx]);
                max = days[idx];
                idx++;
                continue;
            }


            stack.push(days[idx]);
            idx++;

        }

        result.add(stack.size());


        return result.stream()
                .mapToInt(i -> i)
                .toArray();

    }

}
