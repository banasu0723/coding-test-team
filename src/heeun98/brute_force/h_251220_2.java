package heeun98.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_251220_2 {

    static int e;
    static int s;
    static int m;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());


        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        increase(0, 0, 0, 0);



    }

    static void increase(int ce, int cs, int cm, int count) {

        if (ce == 16) {
            ce = 1;
        }
        if (cs == 29) {
            cs = 1;
        }
        if (cm == 20) {
            cm = 1;
        }

        if (ce == e && cs == s && cm == m) {
            System.out.println(count);
            System.exit(0);
        }

        increase(ce + 1, cs + 1, cm + 1, count + 1);

    }
}
