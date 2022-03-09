package A3190뱀;

import java.io.*;
import java.util.*;

public class A3190뱀 {
    static int[] dx = { 0, 1, 0, -1 }; // 우측방향에서부터 + 90º씩 회전 할 때
    static int[] dy = { 1, 0, -1, 0 };
    static int N;
    static int[][] map;
    static int x, y, d, time; // x,y좌표,방향,시간, 몸 길이
    static Queue<Pos> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 보드 크기
        int K = Integer.parseInt(br.readLine()); // 사과 개수
        map = new int[N][N];
        StringTokenizer st;
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            map[i - 1][j - 1] = 4; // 사과가 있는 곳을 4로 저장
        }

        int L = Integer.parseInt(br.readLine());
        x = 0; y = 0; d = 0; time = 1;
        q = new LinkedList<>();
        q.add(new Pos(x, y));
        map[x][y] = 1;

        loop: for (int l = 0; l < L; l++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            int sss = (t - time);
            for (int i = 0; i <= sss; i++) {
                if (!move())
                    break loop;
            }
            d = (c == 'D') ? d + 1 : d - 1; // D이면 오른쪽으로 회전 아니면 왼쪽 회전
            if (d == 4) d = 0;
            if (d == -1) d = 3;
        }

        while (true) {
            if (!move()) break;
        }

        System.out.println(time);
    }

    static boolean move() {
        int nx = x + dx[d];
        int ny = y + dy[d];
        if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 1) return false;
        else { 
            if (map[nx][ny] != 4) { // 사과가 없다면
                Pos pos = q.poll(); // 꼬리 제거
                map[pos.x][pos.y] = 0;
            }
            map[nx][ny] = 1;  // 머리 이동
            q.add(new Pos(nx, ny));
            x = nx;
            y = ny;
            time++;
        }
        return true;
    }
}

class Pos {
    int x, y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}