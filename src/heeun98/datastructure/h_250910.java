package heeun98.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class h_250910 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line);


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (list.size() > 0) {

            idx = (idx + m - 1) % list.size();

            Integer remove = list.remove(idx);


            System.out.println(remove);
        }

        /**
         * idx = 0
         * idx = 2
         * idx = 4
         * idx = 8
         */




    }
}
