package S7964부먹왕국의차원관문;

import java.io.*;
import java.util.*;

public class S7964부먹왕국의차원관문 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/S7964.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int city = Integer.parseInt(st.nextToken()); // 도시 수
            int limit = Integer.parseInt(st.nextToken()); // 제한 거리

            int[] map = new int[city];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < city; i++)
                map[i] = Integer.parseInt(st.nextToken());

            int block = 0; // 이동거리 체크
            int result = 0; // 설치할 차원관문 개수
            for (int i = 0; i < city; i++) {
                block++;
                if (map[i] == 1 ) block = 0;    // 차원관문을 만나면 이동거리 0으로 초기화
                else if (block >= limit && map[i] == 0) { // 최대 이동거리를 넘은 상태에 차원관문도 없다면
                    result += 1;
                    block = 0;
                }
            }
            sb.append("#" + tc + " " + result + "\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
