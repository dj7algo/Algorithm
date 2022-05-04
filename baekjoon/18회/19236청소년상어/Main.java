import java.io.*;
import java.util.*;

/* 
<물고기>
1. 물고기는 번호가 작은 물고기부터 순서대로 이동한다.
2. 이동할 수 있는 칸은 빈 칸과 다른 물고기가 있는 칸, 이동할 수 없는 칸은 상어가 있거나, 공간의 경계를 넘는 칸이다.
3. 각 물고기는 방향이 이동할 수 있는 칸을 향할 때까지 방향을 45도 반시계 회전시킨다.
4. 물고기가 다른 물고기가 있는 칸으로 이동할 때는 서로의 위치를 바꾸는 방식으로 이동한다.
<상어>
1. (0, 0)에 있는 물고기를 먹고, (0, 0)에 들어가게 된다.
2. 물고기의 이동이 모두 끝나면 상어가 이동.
3. 상어는 방향에 있는 칸으로 이동할 수 있는데, 한 번에 여러 개의 칸을 이동할 수 있다.
4. 상어가 물고기가 있는 칸으로 이동했다면, 그 칸에 있는 물고기를 먹고, 그 물고기의 방향을 가지게 된다.
5. 물고기가 없는 칸으로는 이동할 수 없다.
6. 상어가 이동할 수 있는 칸이 없으면 공간에서 벗어나 집으로 간다.

=> 상어가 이동한 후에는 다시 물고기가 이동하며, 이후 이 과정이 계속해서 반복된다.
*/

public class Main {
  static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }; // ↑, ↖, ←, ↙, ↓, ↘, →, ↗
  static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
  static int N, map[][], result = 0;
  static Fish[] fish;

  static class Fish {
    int x, y, dir;
    boolean isAlive;

    Fish(int x, int y, int dir, boolean isAlive) {
      this.x = x;
      this.y = y;
      this.dir = dir;
      this.isAlive = isAlive;
    }
  }

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("19236청소년상어/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = 4;
    map = new int[N][N];
    fish = new Fish[N * N + 1]; // 물고기 번호 1~16

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        int num = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken()) - 1; // 방향 1~8으로 입력 받아지므로 -1해서 0~7로 맞춰줌
        fish[num] = new Fish(i, j, dir, true);
        map[i][j] = num;
      }
    }

    int sx = 0, sy = 0; // 상어의 위치
    int sd = fish[map[0][0]].dir; // 초기 상어의 방향
    int eatSum = map[0][0]; // 먹은 물고기 번호 합 저장 변수 - (0, 0) 물고기 먹음
    fish[map[0][0]].isAlive = false; // (0, 0) 물고기 죽음
    map[0][0] = -1; // 상어가 있는 위치 -1

    dfs(sx, sy, sd, eatSum);

    System.out.println(result);
  }

  private static void dfs(int sx, int sy, int sd, int eatSum) {
    result = Math.max(result, eatSum);

    // 지도와 물고기 배열 복사
    int[][] copyMap = new int[N][N];
    for (int i = 0; i < map.length; i++)
      System.arraycopy(map[i], 0, copyMap[i], 0, map.length);
    Fish[] copyFish = new Fish[fish.length];
    for (int i = 1; i < fish.length; i++)
      copyFish[i] = new Fish(fish[i].x, fish[i].y, fish[i].dir, fish[i].isAlive);

    // 물고기 움직임
    fishMove();

    // 상어이동
    for (int i = 1; i < 4; i++) {
      int nx = sx + dx[sd] * i;
      int ny = sy + dy[sd] * i;

      // 경계를 벗어나지 않고, 물고기가 없는 빈칸이 아닐 경우
      if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != 0) {
        int eatFishNum = map[nx][ny];
        int nd = fish[eatFishNum].dir;
        map[sx][sy] = 0; // 기존 상어의 위치는 이동했으므로 0
        map[nx][ny] = -1; // 상어가 이동한 위치는 -1
        fish[eatFishNum].isAlive = false; // 상어가 잡아 먹은 물고기 죽음

        dfs(nx, ny, nd, eatSum + eatFishNum);

        fish[eatFishNum].isAlive = true; // 물고기 상태, 상어의 위치 원래대로 되돌리기
        map[sx][sy] = -1;
        map[nx][ny] = eatFishNum;
      }
    }

    // 맵 상태, 물고기 정보 되돌리기
    for (int j = 0; j < map.length; j++)
      System.arraycopy(copyMap[j], 0, map[j], 0, map.length);
    for (int i = 1; i <= 16; i++)
      fish[i] = new Fish(copyFish[i].x, copyFish[i].y, copyFish[i].dir, copyFish[i].isAlive);
  }

  private static void fishMove() {
    for (int i = 1; i <= 16; i++) {
      if (!fish[i].isAlive)
        continue; // 이미 죽은 물고기는 패스

      int x = fish[i].x;
      int y = fish[i].y;

      for (int d = 0; d < 8; d++) {
        int nextDir = (fish[i].dir + d) % 8;
        int nx = x + dx[nextDir];
        int ny = y + dy[nextDir];

        if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != -1) { // 이동할 수 있다면
          if (map[nx][ny] == 0) { // 이동할 위치가 빈칸일 경우
            map[x][y] = 0;
            fish[i].x = nx;
            fish[i].y = ny;
          } else { // 바꿀 물고기가 있을경우
            int temp = map[nx][ny]; // 바꿀 물고기 번호
            // 현재 물고기 위치 변경
            fish[i].x = nx;
            fish[i].y = ny;

            map[x][y] = temp;
            fish[temp].x = x;
            fish[temp].y = y;
          }
          map[nx][ny] = i;
          fish[i].dir = nextDir;
          break; // 물고기 위치를 바꿨다면 방향을 더 이상 바꾸지 말고 다음 물고기로
        }
      }
    }
  }
}