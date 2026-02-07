package heeun98.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class h_g_3 {

    static int answer;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        Time[] times = new Time[n * 2];

        for (int i = 0 ; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Time time1 = new Time(start, 's');
            Time time2 = new Time(end, 'e');

            times[i * 2] = time1;
            times[i * 2 + 1] = time2;
        }

        Arrays.sort(times, (t1, t2) -> {
            if (t1.time != t2.time) return t1.time - t2.time;
            return t1.op - t2.op;
        });

        int cnt = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i].op == 'e') {
                cnt--;
                continue;
            }

            if (times[i].op == 's') {
                cnt++;
            }
            answer = Math.max(cnt, answer);
        }

        System.out.println(answer);

    }

    static class Time {
        int time;
        char op;


        public Time(int time, char op) {
            this.time = time;
            this.op = op;
        }
    }

}
