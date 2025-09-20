package banasu0723.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// 1427번 소트인사이드
public class b_250920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        String[] digits = input.split("");
        Arrays.sort(digits, Collections.reverseOrder());

        for(String d:digits){
            sb.append(d);
        }
        System.out.println(sb);

    }
}
