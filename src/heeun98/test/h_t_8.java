package heeun98.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class h_t_8 {


    static String[] ch;
    static int l,c;
    static List<String> answer = new ArrayList<>();
    static String[] mo = new String[]{"a", "e", "i", "o", "u"};

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        ch = new String[c];

        String s = br.readLine();
        st = new StringTokenizer(s);

        for (int i = 0; i < c ; i++) {
            ch[i] = st.nextToken();
        }
        System.out.println(Arrays.toString(ch));
        Arrays.sort(ch);
        dfs(0, 0, "");

        answer.stream()
                .forEach(key -> System.out.println(key));
    }

    public static void dfs(int idx, int size, String str) {
        if (size > l) return;
        if (size == l && contain(str)) {
            System.out.println(str);
            answer.add(str);
            return;
        }
        for (int i = idx; i < ch.length; i++) {
            dfs(i + 1,size + 1, str + ch[i]);
        }
    }

    public static boolean contain(String str) {

        for (int i = 0; i < mo.length; i++) {
            if (str.contains(mo[i])) return true;
        }
        return false;
    }
}
