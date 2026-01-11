package heeun98.session4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class h_4_1 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();

        Map<Character, Integer> rank = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            rank.put(input.charAt(i), rank.getOrDefault(input.charAt(i), 0) + 1);
        }

        char answer = 0;
        int max = Integer.MIN_VALUE;
        for (Character c : rank.keySet()) {
            Integer value = rank.get(c);


            if (max < value) {
                max = value;
                answer = c;
            }
        }

        System.out.println(answer);


    }
}
