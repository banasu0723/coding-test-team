package heeun98.session1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class h_s_4 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());


        ArrayList<String> list = new ArrayList<>();
        for (int i = 0 ; i < 3; i++) {
            String s = br.readLine();
            char[] arr = s.toCharArray();
            int lt = 0;
            int rt = s.length() - 1;

            while (lt < rt) {
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--;
            }
            list.add(String.valueOf(arr));
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
