package heeun98.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class h_250919 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        List<User> list = new ArrayList<>();

        for (int i = 0;i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new User(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        list.stream().sorted((o1, o2) -> {
            if (o1.age != o2.age) {
                return o1.age - o2.age;
            }
            return o1.idx - o2.idx;
        }).forEach(e -> System.out.println(e.age + " " + e.name));
    }

    public static class User {
        int idx;
        int age;
        String name;

        public User(int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }
    }
}
