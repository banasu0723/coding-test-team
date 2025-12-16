package heeun98.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class h_251216 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int number = 0;
        String[] result = new String[n];

        while (count < n) {
            number++;
            String checkNumber = String.valueOf(number);

            if (checkNumber.contains("666")) {
                result[count] = checkNumber;
                count++;
            }

        }
        System.out.println(result[n - 1]);
    }
}
