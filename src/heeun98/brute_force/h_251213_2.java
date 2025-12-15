package heeun98.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class h_251213_2 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for (int i = 1; i < num; i++) {
            int cal = i + sum(i);

            if (cal == num) {
                System.out.println(i);
                return;
            }

        }

        System.out.println(0);
    }

    public static int sum(int num) {

        int sum = 0;

        while (num > 0) {

            sum += num % 10;
            num = num / 10;
        }

        return sum;

    }
}
