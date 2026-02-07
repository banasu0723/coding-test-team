package heeun98.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class h_g_2 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Lecture> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n ; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            list.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        Collections.sort(list, (l1, l2) -> {

            if (l1.end != l2.end) {
                return l1.end - l2.end;
            }
            return l1.start - l2.start;
        });


        int end = list.get(0).end;
        int count = 1;
        for (int i = 1; i < list.size(); i++) {

            if (end <= list.get(i).start) {
                count++;
                end = list.get(i).end;
            }
        }

        System.out.println(count);

    }

    static class Lecture {

        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return start + " ," + end + "\n";
        }
    }
}
