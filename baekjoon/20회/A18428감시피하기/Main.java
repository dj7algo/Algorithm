package A18428감시피하기;

import java.io.*;
import java.util.*;

// T : 선생님, S : 학생, X : 빈칸

public class Main {
  static int dx[] = { -1, 1, 0, 0 }; // 상하좌우
  static int dy[] = { 0, 0, -1, 1 };
  static int N;
  static char[][] map;
  static boolean answer;

  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("A18428감시피하기/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new char[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        map[i][j] = st.nextToken().charAt(0);
      }
    }
    dfs(0, -1, 0);

    if (answer)
      System.out.println("YES");
    else
      System.out.println("NO");
  }

  static void dfs(int r, int c, int cnt) { // 행, 열, 장애물 수
    if (cnt == 3) {
      boolean yes = true;

      loop: for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] != 'T')
            continue;

          // 감시 가능한 학생이 존재하는지
          boolean sw = findS(i, j);

          // 감시 가능
          if (sw == true) {
            yes = false;
            break loop;
          }
        }
      }

      // 감시 불가
      if (yes == true)
        answer = true;
      return;
    }

    // 세로 방향
    for (int i = c + 1; i < N; i++) {
      if (map[r][i] != 'X') continue; // 빈 칸이 아니라면
      map[r][i] = 'O';
      dfs(r, i, cnt + 1);
      map[r][i] = 'X';
    }

    // 가로 방향
    for (int i = r + 1; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] != 'X') continue;
        map[i][j] = 'O';
        dfs(i, j, cnt + 1);
        map[i][j] = 'X';
      }
    }
  }

  static boolean findS(int r, int c) {
    for (int i = 0; i < 4; i++) {
      int nx = r;
      int ny = c;
      while (true) {
        nx += dx[i];
        ny += dy[i];
        if (nx < 0 || nx >= N || ny < 0 || ny >= N)  break;
        if (map[nx][ny] == 'O') break;
        if (map[nx][ny] == 'S') return true;
      }
    }
    return false;
  }

}