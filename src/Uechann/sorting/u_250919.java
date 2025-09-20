package Uechann.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/* 
 * 문제 10814
온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 
이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)

둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다. 
나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 
이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.

출력
첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.

예제 입력 1 
3
21 Junkyu
21 Dohyun
20 Sunyoung
예제 출력 1 
20 Sunyoung
21 Junkyu
21 Dohyun
출처
 */

public class u_250919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<String[]> m = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // members.put(Integer.parseInt(st.nextToken()), st.nextToken());
            m.add(new String[]{st.nextToken(), st.nextToken()});
        }

        m.stream()
            .sorted(Comparator.comparing((String[] a)-> Integer.parseInt(a[0])))
            .forEach(a->System.out.println(a[0] + " " + a[1]));
    }
}

/*
 * Map
 * 
 * HashMap
 * 순서 보장은 안되고 해시 기반이어서 탐색에 빠름
 * 
 * TreeMap
 * 정렬된 Map 자동으로 키 기준으로 정렬
 * 커스텀 정렬 기능 지원
 * 
 * LinkedHashMap
 * 입력한 순서를 기억하고 LRU 캐시 구현할 때도 활용된다.
 * 
 * HashTable
 * HashMap과 비슷하지만 동기화 기능을 지원한다.
 * 그래서 멀티스레드 환경에서 안전하다
 * -> 이거보단
 * 
 * ConcurrentHashMap 사용
 * HashMap의 스레드 안전한 버전
 * 부분적으로만 Lock을 걸어 성능을 최적화 한다.
 * 동시성 환경에서 많이 쓴다.
 * null 키값 허용안한다.
 * 
 */