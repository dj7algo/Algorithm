package A5014스타트링크;

import java.io.*;
import java.util.*;

public class A5014스타트링크 {
    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken()); // 건물 총 층수
        S = Integer.parseInt(st.nextToken()); // 강호 위치
        G = Integer.parseInt(st.nextToken()); // 스타트링크(목적지)
        U = Integer.parseInt(st.nextToken()); // 위로 이동
        D = Integer.parseInt(st.nextToken()); // 아래로 이동

        bfs();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int[] visit = new int[F];
        q.add(S-1);
        visit[S-1] = 1; // 0일 경우 방문 하지 않을걸로 하기 위해서 && 이동 횟수

        while (!q.isEmpty()) {
            int pos = q.poll(); // 현재위치
            if (pos == G-1) { // 목적지 도착
                System.out.println(visit[pos] - 1);
                return;
            }
            if (pos + U < F && visit[pos + U] == 0) {
                visit[pos + U] = visit[pos] + 1;
                q.add(pos + U);
            }
            if (pos - D >= 0 && visit[pos - D] == 0) {
                visit[pos - D] = visit[pos] + 1;
                q.add(pos - D);
            }
            //System.out.println(Arrays.toString(visit)); // 과정확인가능
        }
        System.out.println("use the stairs");
    }
}
