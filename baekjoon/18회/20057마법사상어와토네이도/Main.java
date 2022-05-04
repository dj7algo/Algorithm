import java.io.*;
import java.util.*;

public class Main {
  static int[] dx = { 0, 1, 0, -1 }; // ← ↓ → ↑
  static int[] dy = { -1, 0, 1, 0 };
  static int[][][] spread = {
      { { 0, 0, 2, 0, 0 }, { 0, 10, 7, 1, 0 }, { 5, -1, 0, 0, 0 }, { 0, 10, 7, 1, 0 }, { 0, 0, 2, 0, 0 } },
      { { 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 2, 7, 0, 7, 2 }, { 0, 10, -1, 10, 0 }, { 0, 0, 5, 0, 0 } },
      { { 0, 0, 2, 0, 0 }, { 0, 1, 7, 10, 0 }, { 0, 0, 0, -1, 5 }, { 0, 1, 7, 10, 0 }, { 0, 0, 2, 0, 0 } },
      { { 0, 0, 5, 0, 0 }, { 0, 10, -1, 10, 0 }, { 2, 7, 0, 7, 2 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0 } } };
  static int N, map[][], result;

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("20057마법사상어와토네이도/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 처리
    int x = N / 2, y = N / 2; // 중심지부터 시작
    int d = 0; // 방향
    int s = 1; // 회전 크기
    int dirCnt = 0; // 이동거리 계산
    boolean same = false; // 동일 크기 이동 여부

    out: while (true) {
      while (true) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        dirCnt++; // 이동거리 증가

        if (map[nx][ny] != 0) { // 모래가 0이 아니라면
          move(nx, ny, d);
        }

        x = nx;
        y = ny;
        if (dirCnt == s) { // s만큼 이동했다면 방향을 바꿔줘야함
          dirCnt = 0;
          if (same) { // 2번 동일한 s만큼 이동 했다면
            same = false;
            s++;
          } else same = true;
          
          break;
        }
        if (x == 0 && y == 0)  break out;
      }
      d = (d + 1) % 4;
    }

    System.out.println(result);
  }

  public static void move(int x, int y, int dir) {
    int alph_x = -1;
    int alph_y = -1;
    int origin = map[x][y]; // y값
    int cnt = 0;

    for (int i = x - 2; i <= x + 2; i++) {
      for (int j = y - 2; j <= y + 2; j++) {
        int a = i - (x - 2);
        int b = j - (y - 2);
        if (spread[dir][a][b] == 0) continue;
        if (spread[dir][a][b] == -1) {
          alph_x = i;
          alph_y = j;
          continue;
        }
        // 퍼센트가 담겨있는 칸만 넘어옴
        double percent = (double) spread[dir][a][b] / 100;
        int sand = (int) (origin * (percent));
        cnt += sand;

        if (i < 0 || i >= N || j < 0 || j >= N) { // map에 벗어난 모래들
          result += sand;
        } else {
          map[i][j] += sand; // map 내부 원래 모래에 누적
        }
      }
    }

    if (alph_x < 0 || alph_x >= N || alph_y < 0 || alph_y >= N) { // map에 벗어나면
      result += (origin - cnt); // a부분
    } else {
      map[alph_x][alph_y] += (origin - cnt);
    }

    map[x][y] = 0; // 현재 모래위치는 0으로
  }
}
