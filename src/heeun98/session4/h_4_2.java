package heeun98.session4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class h_4_2 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!map.containsKey(c)) {
                System.out.println("NO");
                return;
            }

            if (map.get(c) > 1) {
                map.put(c, map.get(c) - 1);
                continue;
            }

            if (map.get(c) == 1) {
                map.remove(c);
            }
        }

        if (map.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
