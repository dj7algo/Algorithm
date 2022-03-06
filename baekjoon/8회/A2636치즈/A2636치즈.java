import java.io.*;
import java.util.*;

public class A2636치즈 {
    static int N, M, cheese, cnt, time;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // n*m
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    cheese++;
            }
        }
        while (cheese != 0) {
            time++;
            cnt = cheese; // 한 시간 전에 남아있는 치즈조각 저장할 변수
            bfs();
        }
        System.out.println(time);
        System.out.println(cnt);
    }

    public static void bfs() {
        Queue<int[]> que = new LinkedList<int[]>(); // 치즈가 없으면 추가
        visit = new boolean[N][M];
        que.offer(new int[] { 0, 0 });
        visit[0][0] = true;
        while (!que.isEmpty()) {
            int[] pos = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        que.offer(new int[] { nx, ny });
                    } else { // 치즈가 있을 때
                        cheese--;
                        map[nx][ny] = 0;
                    }
                    visit[nx][ny] = true;
                }
            }
        }
    }
}