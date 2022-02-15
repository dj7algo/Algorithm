import java.util.*;

public class A10157자리배정 {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int C = scan.nextInt(); // 가로
        int R = scan.nextInt(); // 세로

        boolean[][] visit = new boolean[R][C];

        int seat = scan.nextInt(); // 몇 번째 방문자
        if (seat > C * R) { // 방문자가 자리수 보다 많으면
            System.out.print(0);
            scan.close();
            return;
        }
        int x = 0, y = 0;
        int cnt=0;
        int idx = 0;
        for (int i = 0; i < R * C; i++) {
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            if (nx < 0 || ny < 0 || nx >= C || ny >= R || visit[ny][nx]) {  // 범위를 벗어날 경우
                idx = (++idx == 4) ? 0 : idx;
                nx = x + dx[idx];
                ny = y + dy[idx];
            }
            cnt++;
            if (cnt == seat) break;
            visit[y][x]=true;
            
            x = nx;
            y = ny; 
        }
        System.out.print((x+1) + " " + (y+1));
        scan.close();
    }
}
