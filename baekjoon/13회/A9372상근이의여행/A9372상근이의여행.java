package A9372상근이의여행;

import java.io.*;
import java.util.*;

/**
 * A9372상근이의여행
 */
public class A9372상근이의여행 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int N = Integer.parseInt(st.nextToken()); // 국가수
      int M = Integer.parseInt(st.nextToken()); // 비행기 종류

      int[][] plane = new int[M][2];
      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        plane[i][0] = a;  plane[i][1] = b;
      }
      // ======== 입력 끝 ===========
      System.out.println(N-1);
    }
  }
}