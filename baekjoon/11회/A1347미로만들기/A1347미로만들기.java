package A1347미로만들기;

import java.io.*;
import java.util.*;

public class A1347미로만들기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int[] dx = { 1, 0, -1, 0 }; // 남동북서
    int[] dy = { 0, 1, 0, -1 };
    char[][] grid = new char[101][101];
    for(int i=0;i<101;i++) Arrays.fill(grid[i], '#');
    
    int N = Integer.parseInt(br.readLine());
    String move = br.readLine();

    grid[50][50]='.';
    int x = 50, y = 50, dir = 0;
    int max_X = 50, max_Y = 50; 
    int min_X = 50, min_Y = 50;
    for (int i = 0; i < N; i++) {
      char c = move.charAt(i);
      if (c == 'R')                           // 시계 방향
        dir = (dir == 0) ? 3 : dir - 1;
      else if (c == 'L')                      // 반시계 방향
        dir = (dir == 3) ? 0: dir + 1;
      else if (c == 'F') {
        x += dx[dir];
        y += dy[dir];
        grid[x][y]='.';

        if (min_X > x) min_X = x;
        if (min_Y > y) min_Y = y;
        if (max_X < x) max_X = x;
        if (max_Y < y) max_Y = y;
      }
    }

    for (int i = min_X; i <= max_X; i++) {
      for (int j = min_Y; j <=max_Y; j++) sb.append(grid[i][j]);
      sb.append('\n');
    }
    System.out.println(sb.toString().trim());
  }
}

class Pos {
  int x, y;
  Pos(int x, int y) {
    this.x = x;
    this.y = y;
  }
}