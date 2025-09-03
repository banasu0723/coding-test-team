package heeun98;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class h_250903 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String in = br.readLine();
        StringTokenizer st = new StringTokenizer(in);

        Set<Integer> set = new HashSet<>(); // 해시코드 기반

        for (int i = 0; i < n; i++) {
            set.add(Integer.valueOf(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        String confirm = br.readLine();
        st = new StringTokenizer(confirm);
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (set.contains(num)) { // contains 내부에서 hashCode 기반으로 equals 를 체크 -> O(1)
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }


        }


        System.out.println(sb);
    }
}
