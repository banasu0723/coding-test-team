package banasu0723.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 11725 트리의 부모 찾기
public class b_251020 {
    static int x, y, N;
    static int[] parent;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visit = new boolean[N+1];
        parent = new int[N+1];

        for(int i = 0; i < N+1; i++){
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr.get(x).add(y); // x번지에 y 값 추가
            arr.get(y).add(x);

        }
        
        DFS(1); // 초기값 1부터 시작

        for(int i = 2; i<parent.length; i++){
            System.out.println(parent[i]); // DFS에서 얻은 부모 노드 출력
        }

    }

    private static void DFS(int a) { // 초기값a로 시작
        visit[a] = true;
        for(int i: arr.get(a)){
            if(!visit[i]){ // a 번지 방문처리
                parent[i] = a; // a번지 값을 parent에 저장
                DFS(i);
            }
        }
    }
}