package Uechann.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/* 
 * 문제 11650
2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 
둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 
좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

예제 입력 1 
5
3 4
1 1
1 -1
2 2
3 3
예제 출력 1 
1 -1
1 1
2 2
3 3
3 4
 */

public class u_250918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<int[]> dots = new ArrayList<>();
        int x, y;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            dots.add(new int[] { x, y });
        }

        dots.stream()
                .sorted(
                    Comparator.comparingInt((int[] d) -> d[0])  //1차 비교 기준
                              .thenComparing(d -> d[1])         //2차 비교 기준
                )
                .forEach(d -> System.out.println(d[0] + " " + d[1]));
    }
}

/* 
단일 기준일 때: 타입 지정 필요 없음
    - 여기서는 바로 sorted(...)의 파라미터이기 때문에, T가 **스트림의 요소 타입(int[])**로 자연스럽게 고정됩니다.
	- 따라서 arr는 int[]로 추론되고 arr[0]이 정상.

다중 기준일 때: 처음 비교 기준에 타입을 지줭해줘야한다.
    - comparingInt(...)는 자체가 제네릭이라서, 이 호출 안에서 람다의 파라미터 타입을 먼저 정해줘야 한다..
    - 그러나 바깥의 sorted(...)가 기대하는 타입 정보가 람다 파라미터까지 충분히 전파되지 않는 상황이 있어, 
    - arr가 Object로 취급되며 arr[0]에서 컴파일 에러가 납니다.
    - 즉, 첫 단추(첫 람다)에서 T를 못 박지 않으면 이후 체인까지 타입 추론이 꼬입니다.

    자바의 “타겟 타이핑(target typing)”과 제네릭/람다 타입 추론이 항상 깊은 중첩까지 완벽히 전파되는 것은 아니다가 핵심입니다. 
    (JDK 버전에 따라 추론 강도가 달라지는 케이스도 존재)
 */