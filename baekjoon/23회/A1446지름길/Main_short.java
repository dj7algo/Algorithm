package A1446지름길;

import java.io.*;
import java.util.*;

public class Main_short {

  public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("A1446지름길/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken()); // 지름길의 개수
    int D = Integer.parseInt(st.nextToken()); // 고속도로의 길이
    int[][] input = new int[N][3];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int s = Integer.parseInt(st.nextToken()); // 지름길 시작
      int e = Integer.parseInt(st.nextToken()); // 지름길 끝
      int l = Integer.parseInt(st.nextToken()); // 지름길 길이
      if (e > D || e - s <= l) continue; // 역주행X, 기존 고속도로보다 시간이 더 오래걸릴 경우
      input[i][0] = s;
      input[i][1] = e;
      input[i][2] = l;
    }

    int[] dp = new int[D + 1];
    for (int i = 1; i <= D; i++) {
      dp[i] = dp[i - 1] + 1;
      for (int j = 0; j < N; j++) {
        if (input[j][1] == i) // 현재위치에 지름길(도착) 있는 경우
          dp[i] = Math.min(dp[i], dp[input[j][0]] + input[j][2]);
      }
    }
    System.out.println(dp[D]);
  }
}