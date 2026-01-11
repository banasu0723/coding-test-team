package heeun98.session2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class h_2_1 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        String[] numbers = input.split(" ");

        System.out.print(numbers[0] + " ");

        for (int i = 1; i < numbers.length; i++) {
            if (Integer.parseInt(numbers[i - 1]) < Integer.parseInt(numbers[i])) {
                System.out.print(numbers[i] + " ");
            }
        }

    }
}
