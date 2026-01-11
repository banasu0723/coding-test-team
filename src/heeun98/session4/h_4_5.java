package heeun98.session4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_4_5 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();


        Map<Character, Integer> result = new HashMap<>();
        
        for (int i = 0; i < b.length(); i++) {
            result.put(b.charAt(i), result.getOrDefault(b.charAt(i), 0) + 1);
        }

        Map<Character, Integer> map = new HashMap<>();
        int k = b.length();
        for (int i = 0; i < k - 1; i++) {
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
        }

        int lt = 0;
        int count = 0;
        int length = a.length();
        for (int rt = k - 1; rt < length; rt++) {
            map.put(a.charAt(rt), map.getOrDefault(a.charAt(rt), 0) + 1);


            Map<Character, Integer> result2 = new HashMap<>();

            for (int i = 0; i < b.length(); i++) {
                result2.put(b.charAt(i), result2.getOrDefault(b.charAt(i), 0) + 1);
            }


            if (isCheck(result2, map)) {
                count++;
            }
            map.put(a.charAt(lt), map.get(a.charAt(lt)) - 1);

            if (map.get(a.charAt(lt)) == 0) {
                map.remove(a.charAt(lt));
            }
            lt++;
        }


        System.out.println(count);




    }

    private static boolean isCheck(Map<Character, Integer> result, Map<Character, Integer> map) {

        return result.equals(map);
    }
}
