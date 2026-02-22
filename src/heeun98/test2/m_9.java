package heeun98.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class m_9 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String key = br.readLine();
        String pass = br.readLine();

        int col = key.length();
        int row = pass.length() / key.length();

        char[][] after = new char[row][col];

        int idx = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                after[j][i] = pass.charAt(idx);
                idx++;
            }
        }

        Node[] nodes = new Node[col];

        for (int i = 0; i < col; i++) {
            nodes[i] = new Node(key.charAt(i), i);
        }

        Arrays.sort(nodes, (o1, o2) -> o1.al - o2.al);


        char[][] ordinary = new char[row][col];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                ordinary[j][nodes[i].idx] = after[j][i];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sb.append(ordinary[i][j]);
            }
        }
        System.out.println(sb.toString());

    }
    static class Node {
        char al;
        int idx;

        Node(char al, int idx) {
            this.al = al;
            this.idx = idx;
        }
    }
}
