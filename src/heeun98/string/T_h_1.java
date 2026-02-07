package heeun98.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class T_h_1 {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().toLowerCase();
        String n = br.readLine();

        char ch = Character.toLowerCase(n.charAt(0));


        long count = input.chars()
                .filter(c -> c == ch)
                .count();


        System.out.println(count);
    }

}
