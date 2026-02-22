package heeun98.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class m_11 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());
        String input = br.readLine();

        String io = "IOI";
        StringBuilder sb = new StringBuilder(io);
        for (int i = 1; i < n; i++) {
            sb.append("OI");
        }

        int len = sb.toString().length();

        int lt = 0;
        int count = 0;
        for (int rt = lt + len; rt <= input.length(); rt++) {
            String substring = input.substring(lt, rt);
            if (substring.equals(sb.toString())) count++;
            lt++;
        }
        System.out.println(count);
    }
}
