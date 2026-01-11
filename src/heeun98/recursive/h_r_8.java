package heeun98.recursive;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class h_r_8 {

    static Node root;
    static boolean[] visit = new boolean[8];
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        dfs(root, 0);

        System.out.println(result);
    }

    static void dfs(Node root, int distance) {

        if (root.lt == null && root.rt == null) {
            result = Math.min(result, distance);
            return;
        }

        dfs(root.lt, distance + 1);

        dfs(root.rt, distance + 1);
    }




}
