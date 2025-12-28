package heeun98.session1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class h_s_3 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] arr = input.split(" ");

        Arrays.sort(arr, Comparator.comparingInt(s -> s.length()));

        System.out.println(arr[0]);
    }
}
