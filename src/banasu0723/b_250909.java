package banasu0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b_250909 {
    // 1764번 듣보잡
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int total = 0;

        String[] nohear = new String[N];
        List<String> result = new ArrayList<>(); // 듣도잡 친구들

        // 듣도 못한 사람
        for(int i = 0; i < N; i++){
            nohear[i] = br.readLine();
        }

        Arrays.sort(nohear); // 이진 탐색을 위한 정렬

        // 보도 못한 사람중에 겹치는 사람 있나 확인
        for(int i = 0; i < M; i++){
            String name = br.readLine();
            if(Arrays.binarySearch(nohear, name) >= 0){
                result.add(name);
            }
        }

        Collections.sort(result);

        sb.append(result.size()).append("\n");
        for(String name : result){
            sb.append(name).append("\n");
        }

        System.out.println(sb);


    }
}