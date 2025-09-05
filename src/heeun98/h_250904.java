package heeun98;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class h_250904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();;

        for (int i = 0;i < k; i++) {

            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                stack.pop();
                continue;
            }
            stack.push(num);
        }

        System.out.println(stack.stream()
                .mapToInt(i -> i)
                .sum());
    }
}
