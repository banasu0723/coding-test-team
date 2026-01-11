package heeun98.session5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class h_5_4 {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String input = br.readLine();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i< input.length(); i++) {
            char c = input.charAt(i);

            if (c >= '0' && c <= '9') {
                st.push(c - '0');
            } else {
                int num1 = st.pop();
                int num2 = st.pop();


                if (c == '*') {
                    int tmp = num2 * num1;
                    st.push(tmp);
                    continue;
                }

                if (c == '/') {
                    int tmp = num2 / num1;
                    st.push(tmp);
                    continue;
                }

                if (c == '+') {
                    int tmp = num2 + num1;
                    st.push(tmp);
                    continue;
                }

                if (c == '-') {
                    int tmp = num2 - num1;
                    st.push(tmp);
                    continue;
                }
            }
        }


        System.out.println(st.pop());

    }
}
