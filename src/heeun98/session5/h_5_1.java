package heeun98.session5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class h_5_1 {


    public static void main(String[] args) throws IOException {

        Stack<Character> st = new Stack<>();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                st.push(c);
                continue;
            }
            if (c == ')' && st.empty()) {
                System.out.println("NO");
                return;
            }
            st.pop();
        }

        if (st.empty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
