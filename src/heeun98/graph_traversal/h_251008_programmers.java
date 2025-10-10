package heeun98.graph_traversal;
import java.util.*;

public class h_251008 {


    /**
     * 프로그래머스 "같은 숫자는 싫어"

     */
    public static void main(String[] args) {

        int[] arr = {1, 1, 3, 3, 0, 1, 1};


        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        List<Integer> result = new ArrayList<>();

        for (int i =0 ;i < arr.length; i++) {

            if (!stack.isEmpty() && stack.peek() == arr[i]) {
                continue;
            }

            stack.push(arr[i]);
        }

        stack.stream()
                .mapToInt(i -> i)
                .toArray();

    }
}
