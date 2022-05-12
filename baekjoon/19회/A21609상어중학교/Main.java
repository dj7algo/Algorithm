package A21609상어중학교;

import java.io.*;
import java.util.*;

/*
 * 검정 : -1, 무지개 : 0, 일반 : M이하 숫자
 * 1. 크기가 가장 큰 블록 그룹을 찾는다. 그러한 블록 그룹이 여러 개라면 포함된 무지개 블록의 수가 가장 많은 블록 그룹, 
      그러한 블록도 여러개라면 기준 블록의 행이 가장 큰 것을, 그 것도 여러개이면 열이 가장 큰 것을 찾는다.
 * 2. 1에서 찾은 블록 그룹의 모든 블록을 제거한다. 블록 그룹에 포함된 블록의 수를 B라고 했을 때, B^2점을 획득한다.
 * 3.격자에 중력이 작용한다.
 * 4. 격자가 90도 반시계 방향으로 회전한다.
 * 5. 다시 격자에 중력이 작용한다.
 */
public class Main {
  static int N, M, answer;
  static int[][] map;
  static boolean[][] visited;
  static LinkedList<Block> list = new LinkedList<>();
  static int[] dx = { 1, 0, -1, 0 }; // 하우상좌 (반시계방향)
  static int[] dy = { 0, 1, 0, -1 };

  static class Block implements Comparable<Block> {
    int totalPoint, rainbowPoint, row, col;

    public Block(int totalPoint, int rainbowPoint, int row, int col) {
      this.totalPoint = totalPoint;
      this.rainbowPoint = rainbowPoint;
      this.row = row;
      this.col = col;
    }

    // 재정렬
    public int compareTo(Block o) {
      if (this.totalPoint == o.totalPoint) {
        if (this.rainbowPoint == o.rainbowPoint) {
          if (this.row == o.row) {
            return o.col - this.col; // 열
          }
          return o.row - this.row;  // 행
        }
        return o.rainbowPoint - this.rainbowPoint; // 무지개 블록 수
      }
      return o.totalPoint - this.totalPoint; // 블록 개수
    }
  }

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("A21609상어중학교/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) 
        map[i][j] = Integer.parseInt(st.nextToken());
    }

    while (true) {
      // 블록 그룹 찾기 2 이상 아니면 break;
      visited = new boolean[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] > 0 && visited[i][j] == false) {
            bfs(i, j, true);
          }
        }
      }
      if (list.isEmpty()) break;

      Collections.sort(list);
      // 찾은 블록 없애기
      visited = new boolean[N][N];
      bfs(list.get(0).row, list.get(0).col, false);
      removeBlock();

      // 중력
      gravity();
      // 반시계
      map = rotate();
      // 중력
      gravity();

      list.clear();
    }
    System.out.println(answer);
  }

  private static int[][] rotate() {
    int[][] temp = new int[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        temp[N - j - 1][i] = map[i][j];
      }
    }

    return temp;
  }

  private static void gravity() {
    for (int j = 0; j < N; j++) {
      for (int i = N - 1; i >= 0; i--) {
        for (int k = i; k < N - 1; k++) {
          if (map[k][j] == -1)
            continue;
          if (map[k][j] != -2 && map[k + 1][j] == -2) {
            int temp = map[k][j];
            map[k][j] = -2;
            map[k + 1][j] = temp;
          }
        }
      }
    }
  }

  private static void removeBlock() {
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (visited[i][j] == true) {
          count++;
          map[i][j] = -2;
        }
      }
    }
    answer += (int) Math.pow(count, 2); // 점수
  }

  private static void bfs(int x, int y, boolean flag) {
    Queue<int[]> queue = new LinkedList<int[]>();
    int blockPoint = map[x][y]; // 기준 블록 색상
    visited[x][y] = true;
    queue.offer(new int[] { x, y });
    int totalPoint = 1;  // 총 블록 개수
    int rainbowPoint = 0; // 무지개 블록 수

    while (!queue.isEmpty()) {
      int cur[] = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (0 > nx || nx >= N || 0 > ny || ny >= N || visited[nx][ny] == true)
          continue;
        if (map[nx][ny] == blockPoint || map[nx][ny] == 0) { // 같은 색상의 블록 또는 무지개 블록 
          if (map[nx][ny] == 0)
            rainbowPoint += 1;
          totalPoint += 1;
          visited[nx][ny] = true;
          queue.offer(new int[] { nx, ny });
        }
      }
    }
    
    // 블록 그룹 생성(총 블록수, 무지개 블록수, 기준 블록 위치)
    if (totalPoint >= 2)
      list.add(new Block(totalPoint, rainbowPoint, x, y));
    
    if (flag == true) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] == 0)
            visited[i][j] = false;
        }
      }
    }

  }
}