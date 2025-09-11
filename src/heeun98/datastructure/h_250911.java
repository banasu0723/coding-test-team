package heeun98.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class h_250911 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {

            String line = br.readLine();
            Stack<Character> st = new Stack<>();

            if (line.equals(".")) {
                break;
            }

            char[] arr = line.toCharArray();

            boolean flag = false;

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] == '(') {
                    st.push(arr[i]);
                    continue;
                }

                if (arr[i] == ')' && st.isEmpty() || arr[i] == ')' && st.peek() == '[') {
                    flag = true;
                    break;
                }

                if (arr[i] == ')' && st.peek() == '[') {
                    flag = true;
                    break;
                }


                if (arr[i] == ')' && st.peek() == '(') {
                    st.pop();
                    continue;
                }

                if (arr[i] == '[') {
                    st.push(arr[i]);
                    continue;
                }

                if (arr[i] == ']' && st.isEmpty()) {
                    flag = true;
                    break;
                }
                if (arr[i] == ']' && st.peek() == '(') {
                    flag = true;
                    break;
                }

                if (arr[i] == ']' && st.peek() == '[') {
                    st.pop();
                    continue;
                }
            }

            if (!st.isEmpty()) {
                sb.append("no\n");
                continue;
            }
            if (st.isEmpty() && !flag){
                sb.append("yes\n");
                continue;
            }
            if (flag) {
                sb.append("no\n");
            }


        }

        System.out.println(sb);

    }
}
