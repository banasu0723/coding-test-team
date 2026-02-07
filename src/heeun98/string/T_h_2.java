package heeun98.string;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class T_h_2 {

    public static void main(String[] args) throws Exception{



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        int[] arr = new int[n];

        st = new StringTokenizer(input);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = k - 1;


        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i <= rt; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }


        String answer = "";
        answer += map.size();

        while (rt < n - 1) {


            int val = arr[lt];
            map.put(val, map.get(val) - 1);
            if (map.get(val) == 0) map.remove(val);


            lt++;
            rt++;
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);

            answer += " " + map.size();
        }

        System.out.println(answer);
    }
}
