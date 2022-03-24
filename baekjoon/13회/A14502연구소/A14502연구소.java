package A14502연구소;

import java.io.*;
import java.util.*;

class Pos {
  int x;
  int y;

  Pos(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class A14502연구소 {
  public static final int[] dx = { 0, 0, 1, -1 };
  public static final int[] dy = { 1, -1, 0, 0 };
  public static int N, M;
  public static int[][] inputAry;
  public static int[][] map;
  public static int answer = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(br.readLine()," ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    inputAry = new int[N][M];
    map = new int[N][M];

    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) inputAry[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
    }

    dfs(0);
    System.out.println(answer);
  }

  // 벽 기둥 3개를 세우기 위한 함수
  public static void dfs(int cnt) {
    if (cnt == 3) {
      bfs();
      return;
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0) {
          map[i][j] = 1;
          dfs(cnt + 1);
          map[i][j] = 0;
        }
      }
    }
  }

  public static void bfs() {
    int[][] virusMap = new int[N][M];
  
    for (int i = 0; i < N; i++)
      System.arraycopy(map[i], 0, virusMap[i], 0,virusMap[i].length); // 깊은 복사. 값을 바꿔도 서로 영향x

    Queue<Pos> q = new LinkedList<Pos>(); // 바이러스 위치 저장
    for (int i = 0; i < N; i++)
      for (int j = 0; j < M; j++)
        if (virusMap[i][j] == 2) q.add(new Pos(i, j));

    while (!q.isEmpty()) {
      Pos p = q.poll();
      int x = p.x;
      int y = p.y;
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < N && ny < M && virusMap[nx][ny] == 0) {
            virusMap[nx][ny] = 2;
            q.add(new Pos(nx, ny));
        }
      }
    }
    calAnswer(virusMap);
  }

  public static void calAnswer(int[][] virusMap) {
    int cnt = 0;
    for (int i = 0; i < N; i++)
      for (int j = 0; j < M; j++)
        if (virusMap[i][j] == 0)
          ++cnt;

    answer = Math.max(cnt, answer);
  }
}
