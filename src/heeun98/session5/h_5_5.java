package heeun98.session5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class h_5_5 {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> st = new Stack<>();

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {


            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else {

                st.pop();

                if (s.charAt(i - 1) == ')') {
                    answer = answer + 1;
                } else {
                    answer = answer + st.size();
                }
            }
        }

        System.out.println(answer);

    }
}
