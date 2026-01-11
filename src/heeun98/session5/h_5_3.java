package heeun98.session5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class h_5_3 {


    public static void main(String[] args) throws IOException {

        Stack<Character> st = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();


        char[] arr = s.toCharArray();

        for (char c : arr) {

            if (c == '(') {
                st.push(c);
                continue;
            }

            if (!(c == '(' || c == ')')) {
                st.push(c);
                continue;
            }

            while (!st.empty() && st.peek() != '(') {
                st.pop();
            }
            if (!st.empty()) {
                st.pop();
            }

        }

        ArrayList<Character> characters = new ArrayList<>(st);
        for (Character character : characters) {
            System.out.print(character);
        }

    }
}
