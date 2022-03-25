package A21610마법사상어와비바라기;

import java.io.*;
import java.util.*;

public class Main {
  static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
  static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
  static Queue<Pos> cloud = new LinkedList<>();
  static int[][] map;
  static boolean[][] visit;
  static int N, M, dir, s;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    cloud.add(new Pos(N - 1, 0));
    cloud.add(new Pos(N - 1, 1));
    cloud.add(new Pos(N - 2, 0));
    cloud.add(new Pos(N - 2, 1));

    for (int i = 0; i < M; i++) {
      visit = new boolean[N][N];
      st = new StringTokenizer(br.readLine(), " ");
      dir = Integer.parseInt(st.nextToken()) - 1;
      s = Integer.parseInt(st.nextToken());
      move();
      rain();
      direction();
      make();
    }
    int res = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++)
        res += map[i][j];
    }
    System.out.println(res);
  }

  private static void make() {
    // TODO Auto-generated method stub
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] >= 2 && visit[i][j] == false) {
          map[i][j] -= 2;
          cloud.add(new Pos(i, j));
        }
      }
    }
  }

  private static void direction() {
    int size = cloud.size();
    for (int i = 0; i < size; i++) {
      Pos pos = cloud.poll();
      int x = pos.x;
      int y = pos.y;
      int cnt = 0;
      for (int j = 1; j <= 4; j++) {
        int nx = x + dx[j * 2 - 1];
        int ny = y + dy[j * 2 - 1];
        if (0 > nx || nx >= N || 0 > ny || ny >= N)
          continue;
        if (map[nx][ny] == 0)
          continue;
        cnt++;
      }
      map[x][y] += cnt;

    }
  }

  private static void rain() {
    int size = cloud.size();
    for (int i = 0; i < size; i++) {
      Pos pos = cloud.poll();
      visit[pos.x][pos.y] = true;
      map[pos.x][pos.y] = map[pos.x][pos.y] + 1;
      cloud.add(new Pos(pos.x, pos.y));
    }
  }

  private static void move() {
    int size = cloud.size();

    for (int i = 0; i < size; i++) {
      Pos pos = cloud.poll();
      int x = pos.x;
      int y = pos.y;
      for (int j = 0; j < s; j++) {
        x = x + dx[dir];
        y = y + dy[dir];
        if (0 > x)
          x += N;
        else if (x >= N)
          x -= N;
        if (0 > y)
          y += N;
        else if (y >= N)
          y -= N;
      }
      cloud.add(new Pos(x, y));
    }
  }
}

class Pos {
  int x, y;

  Pos(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
