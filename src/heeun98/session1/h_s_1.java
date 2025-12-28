package heeun98.session1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class h_s_1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String s = br.readLine();
        char input2 = s.charAt(0);


        System.out.println(solution(input, input2));
    }

    public static int solution(String input, char c) {

        char lowerCase = Character.toLowerCase(c);
        String real = input.toLowerCase();


        int count = 0;
        for (char c1 : real.toCharArray()) {
            if (c1 == lowerCase) {
                count++;
            }
        }

        return count;
    }
}
