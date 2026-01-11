package heeun98.session6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class h_6_1 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] memory = new int[s];
        int[] task = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            task[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int num = task[i];
            boolean flag = false;
            int idx = 0;
            for (int j = 0; j < s; j++) {

                if (memory[j] == num) {
                    int tmp = memory[j];
                    for (int k = j - 1; k >= 0; k--) {
                        memory[k + 1] = memory[k];
                    }
                    memory[0] = tmp;
                    flag = true;
                    break;
                }

                if (memory[j] == 0) {
                    idx = j;
                    break;
                }
                idx = j;
            }

            if (!flag) {
                for (int k = idx - 1; k >= 0; k--) {
                    memory[k + 1] = memory[k];
                }
                memory[0] = num;
            }
        }

        for (int i = 0; i < s; i++) {
            System.out.print(memory[i] + " ");
        }
    }
}
