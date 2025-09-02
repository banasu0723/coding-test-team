package heeun98;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class h_250902 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        Stack<Integer> stack = new Stack<>();
        String op;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {

            
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            if (input.contains("push")) {
                op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
                continue;
            }

            if (input.equals("pop")) {
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    Integer pop = stack.pop();
                    String num = String.valueOf(pop);
                    sb.append(num + "\n");
                }
                continue;

            }

            if (input.equals("size")) {
                sb.append(stack.size() + "\n");
                continue;
            }

            if (input.equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
                continue;
            }

            if (input.equals("top")) {

                if (stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.peek() + "\n");
                }
                continue;
            }

        }

        System.out.println(sb.toString());


    }
}
