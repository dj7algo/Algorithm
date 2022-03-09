package A9207페그솔리테어;

import java.io.*;

/*
- 각 구멍에는 핀을 하나 꽂을 수 있다.
- 핀은 수평, 수직 방향으로 인접한 핀을 뛰어넘어서 그 핀의 다음 칸으로 이동하는 것만 허용.
- 핀을 적절히 움직여서 게임판에 남아있는 핀의 개수를 최소로 하려고 할 때 최소 이동횟수.
- '.'는 빈 칸, 'o'는 핀이 꽂혀있는 칸, '#'는 구멍이 없는 칸이다. 핀의 개수는 최대 8이다.
- 핀을 움직여서 남길 수 있는 핀의 최소 개수와 그 개수를 만들기 위해 필요한 최소 이동 횟수를 출력한다.
*/

public class A9207페그솔리테어 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int N = 5, M = 9, resultCnt, resultMove;
    static char[][] map = new char[N][M];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int pin = 0;
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == 'o')
                        pin++;
                }
            }
            resultCnt = pin;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 'o')
                        dfs(i, j, pin, 0);
                }
            }
            br.readLine(); // 다음 테스트케이스를 위해
            sb.append(resultCnt + " " + resultMove + "\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int x, int y, int cnt, int move) {
        if (cnt <= resultCnt) {
            resultCnt = cnt;
            resultMove = move;
        }
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 'o') {
                int nnx = nx + dx[k];
                int nny = ny + dy[k];
                if (nnx >= 0 && nnx < N && nny >= 0 && nny < M && map[nnx][nny] == '.') {
                    map[x][y] = map[nx][ny] = '.';
                    map[nnx][nny] = 'o';

                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if (map[i][j] == 'o')
                                dfs(i, j, cnt - 1, move + 1);
                        }
                    }

                    map[x][y] = map[nx][ny] = 'o';
                    map[nnx][nny] = '.';
                }
            }
        }
    }
}