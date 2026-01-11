package heeun98.session6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_6_2 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        Set<Integer> set = new HashSet<>(list);

        if (list.size() != set.size()) {
            System.out.println("D");
            return;
        }
        System.out.println("U");



    }
}
