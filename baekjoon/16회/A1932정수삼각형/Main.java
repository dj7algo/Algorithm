package A1932정수삼각형;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[][] map = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      for (int j = 0; j <= i; j++)
        map[i][j] = Integer.parseInt(st.nextToken());
    }

    for (int i = N - 1; i > 0; i--) {
      for (int j = 0; j < i; j++)
        map[i - 1][j] += Math.max(map[i][j], map[i][j + 1]);
    }

    System.out.println(map[0][0]);
  }
}
