package heeun98.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class h_250909 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int num = 1;
        int pre = 0;
        boolean flag = true;

        for (int i = 0; i < n; i++) {

            int input = Integer.parseInt(br.readLine());

            while (num <= input) {
                stack.push(num);
                num++;
                sb.append("+\n");
            }


            if (!stack.isEmpty() && input == stack.peek()) {
                stack.pop();
                sb.append("-\n");
            } else {
                flag = false;
            }


        }
        if (!flag) {
            System.out.println("NO");
            return;
        }

        System.out.println(sb);

    }
}
