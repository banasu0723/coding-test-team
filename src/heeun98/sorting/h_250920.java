package heeun98.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class h_250920 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        Arrays.stream(input.split(""))
                .sorted(Comparator.reverseOrder())
                .forEach(e -> sb.append(e));
        System.out.println(sb);

    }
}
