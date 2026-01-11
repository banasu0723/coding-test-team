package heeun98.session4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class h_5_6 {

    static int k;
    static int[] arr;
    static List<Integer> result = new ArrayList<>();


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt((st.nextToken()));

        arr = new int[n];

        String s = br.readLine();
        st = new StringTokenizer(s);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    set.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }


        List<Integer> list = new ArrayList<>(set);

        if (k > list.size() - 1){
            System.out.println(-1);
            return;
        }
        System.out.println(list.get(k - 1));

    }


}
