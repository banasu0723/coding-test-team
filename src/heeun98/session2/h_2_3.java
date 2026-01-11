package heeun98.session2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class h_2_3 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] playerA = br.readLine().split(" ");
        String[] playerB = br.readLine().split(" ");


        for (int i = 0; i < n; i++) {

            int a = Integer.parseInt(playerA[i]);
            int b = Integer.parseInt(playerB[i]);

            if (a == 1 && b == 2) {
                System.out.println("B");
                continue;
            }

            if (a == 1 && b == 3) {
                System.out.println("A");
                continue;
            }

            if (a == 2 && b == 1) {
                System.out.println("A");
                continue;
            }

            if (a == 2 && b == 3) {
                System.out.println("B");
                continue;
            }

            if (a == 3 && b == 1) {
                System.out.println("B");
                continue;
            }

            if (a == 3 && b == 2) {
                System.out.println("A");
                continue;
            }

            System.out.println("D");




        }


    }
}
