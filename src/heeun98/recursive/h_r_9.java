package heeun98.recursive;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class h_r_9 {

    static Node root;
    static boolean[] visit = new boolean[8];

    public static void main(String[] args) throws IOException {

        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        int result = bfs(root);

        System.out.println(result);
    }

    static int bfs(Node root) {

        Queue<Node> que = new LinkedList<>();
        visit[root.data] = true;
        que.offer(root);

        int L = 0;
        while (!que.isEmpty()) {

            int len = que.size();

            for (int i = 0; i < len; i++) {
                Node poll = que.poll();

                if (poll.rt == null && poll.lt == null) return L;

                if (poll.lt != null) {
                    que.offer(poll.lt);
                }

                if (poll.rt != null) {
                    que.offer(poll.rt);
                }
            }
            L++;
        }

        return -1;
    }




}
