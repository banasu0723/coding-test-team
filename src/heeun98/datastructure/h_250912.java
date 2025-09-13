package heeun98.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class h_250912 {

    public static void main(String[] args) throws IOException {

        Set<Integer> set = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for (int i = 0; i < n; i++) {
            set.add(Integer.valueOf(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            Integer number = Integer.valueOf(st.nextToken());
            sb.append(set.contains(number) ? 1 + " " : 0 + " ");
        }

        System.out.println(sb);

    }
}
