package A7569토마토;

import java.io.*;
import java.util.*;

public class A7569토마토 {
    static int dh[] = { 1, -1, 0, 0, 0, 0 }; // 위아래앞뒤왼오
    static int dx[] = { 0, 0, -1, 1, 0, 0 };
    static int dy[] = { 0, 0, 0, 0, -1, 1 };
    static int[][][] box;
    static Queue<Pos> q;
    static int M, N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        q = new LinkedList<Pos>();
        int sum = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        q.add(new Pos(h, n, m));
                        sum++;
                    }
                }
            }
        }
        if (sum == H * M * N) { // 토마토 개수가 상자칸수와 같으면 모두 익은 토마토
            System.out.println(0);
            return;
        }

        bfs();
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Pos tomato = q.poll();
            for (int i = 0; i < 6; i++) {
                int nh = tomato.h + dh[i];
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                if (nh < 0 || nx < 0 || ny < 0 || nh >= H || nx >= N || ny >= M || box[nh][nx][ny] != 0)
                    continue;
                box[nh][nx][ny] = box[tomato.h][tomato.x][tomato.y] + 1;
                q.add(new Pos(nh, nx, ny));
            }
        }
        int max = 0;
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (box[h][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, box[h][i][j]);
                }
            }
        }
        System.out.println(max - 1);

    }
}

class Pos {
    int h, x, y;

    Pos(int h, int x, int y) {
        this.h = h;
        this.x = x;
        this.y = y;
    }
}
