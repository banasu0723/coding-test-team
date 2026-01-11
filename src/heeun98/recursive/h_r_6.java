package heeun98.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class h_r_6 {

    static Node root;
    static boolean[] visit = new boolean[8];
    public static void main(String[] args) throws IOException {


        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);


        dfs(root);


    }

    static void dfs(Node root) {

        System.out.print(root.data + " ");
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {

            Node poll = que.poll();

            Node lt = poll.lt;
            Node rt = poll.rt;

            if (lt != null) {
                que.offer(lt);
                System.out.print(lt.data + " ");
            }

            if (rt != null) {
                que.offer(rt);
                System.out.print(rt.data + " ");
            }
        }



    }




}
