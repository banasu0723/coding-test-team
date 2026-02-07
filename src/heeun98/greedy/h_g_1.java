package heeun98.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class h_g_1 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            list.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        Collections.sort(list, (p1, p2) -> {
            return p2.h - p1.h;
        });
        int count = 0;
        int maxWeight = 0;

        for (Person person : list) {

            if (person.w > maxWeight) {
                count++;
                maxWeight = person.w;
            }
        }

        System.out.println(count);

    }

    static class Person{
        int h;
        int w;

        public Person(int h, int w) {
            this.h = h;
            this.w = w;
        }

        public String toString() {
            return h + "," + w + "\n";
        }
    }
}
