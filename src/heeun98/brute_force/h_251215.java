package heeun98.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class h_251215 {

    static int num;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        num = Integer.parseInt(br.readLine());

        if (num < 100) {
            System.out.println(num);
            return;
        }

        int count = 99;
        for (int i = 100; i <= num; i++) {
            if (isHanSu(i)) {
                count++;
            }
        }

        System.out.println(count);


    }

    private static boolean isHanSu(int i) {

        String num = String.valueOf(i);
        String[] split = num.split("");
        int[] array = Arrays.stream(split)
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();

        if (array[1] - array[0] == array[2] - array[1]) {
            return true;
        }
        return false;
    }


}
