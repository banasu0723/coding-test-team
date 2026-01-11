package heeun98.session2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class h_2_2 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();

        String[] students = input.split(" ");


        int max = Integer.parseInt(students[0]);

        int count = 1;

        for (int i = 1; i < students.length; i++) {
            if (max < Integer.parseInt(students[i])) {
                count++;
                max = Integer.parseInt(students[i]);
            }
        }

        System.out.println(count);


    }
}
