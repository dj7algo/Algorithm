package A13901로봇;

import java.util.Scanner;

public class A13901로봇 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int R = scan.nextInt(); // 방크기(세로)
    int C = scan.nextInt(); // 방크기(가로)
    boolean[][] visit = new boolean[R][C];

    int k = scan.nextInt(); // 장애물 수
    for (int i = 0; i < k; i++) {
      int br = scan.nextInt(); // 장애물 위치x
      int bc = scan.nextInt(); // 장애물 위치y
      visit[br][bc] = true;
    }
    int sr = scan.nextInt(); // 로봇 위치x
    int sc = scan.nextInt(); // 로봇 위치y
    visit[sr][sc] = true;
    int[] dir = { scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt() }; // 방향(1-위,2-하,3-좌,4-우)

    int idx = 0; // 방향에 대한 idx
    loop: while (true) {
      //System.out.println("====================");
      // for (int j = 0; j < visit.length; j++) {
      //   System.out.println(Arrays.toString(visit[j]));
      // }
      int[] go = direction(dir[idx]); // 방향에 대한 x,y값 가져옴
      int nx = sr + go[0];
      int ny = sc + go[1];
      // 이동 중 벽이나 방문한 지역, 장애물을 만날 경우 로봇은 사용자가 지정한 다음 방향으로 움직인다.
      int count = 0;
      while ((nx < 0 || nx >= R || ny < 0 || ny >= C || visit[nx][ny])) {
        if (++count == 4)  break loop; // 4방을 탐색해도 이동 할 수 없다면 break;
        idx = (idx + 1) % 4;
        go = direction(dir[idx]);
        nx = sr + go[0];
        ny = sc + go[1];
      }
      visit[nx][ny] = true;
      sr = nx;
      sc = ny;
    }

    System.out.print(sr + " " + sc);
  }

  static int[] direction(int dir) {
    int dx = 0, dy = 0;
    if (dir == 1) { // 상
      dx = -1;
      dy = 0;
    } else if (dir == 2) { // 하
      dx = 1;
      dy = 0;
    } else if (dir == 3) { // 좌
      dx = 0;
      dy = -1;
    } else { // 우
      dx = 0;
      dy = 1;
    }
    return new int[] { dx, dy };
  }
}
