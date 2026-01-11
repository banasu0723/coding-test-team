package heeun98.session4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class h_4_2 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        Map<Character, Integer> map1 = new HashMap<>();
        String b = br.readLine();
        Map<Character, Integer> map2 = new HashMap<>();

        if (a.length() != b.length()) {
            System.out.println("NO");
            return;
        }


        for (int i = 0; i < a.length(); i++) {
            map1.put(a.charAt(i), map1.getOrDefault(a.charAt(i), 0) + 1);
            map2.put(b.charAt(i), map2.getOrDefault(b.charAt(i), 0) + 1);
        }

        for (Character c : map1.keySet()) {
            if (map1.get(c) != map2.get(c)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");


    }
}
