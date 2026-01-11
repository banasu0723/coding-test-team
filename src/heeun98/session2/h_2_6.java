package heeun98.session2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class h_2_6 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        String s = br.readLine();
        String[] numbers = s.split(" ");

        for (String number : numbers) {
            String num = new StringBuffer(number).reverse().toString();
            int i = Integer.parseInt(num);
            if (isMinority(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean isMinority(int num) {

        if (num == 1) return false;
        if (num == 2) return true;

        for (int i = 2; i <= num / 2 + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
