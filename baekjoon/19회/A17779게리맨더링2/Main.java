package A17779게리맨더링2;

import java.io.*;
import java.util.*;

public class Main {
  static int N, totalPeople;
  static int[][] map;

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("A17779게리맨더링2/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        totalPeople += map[i][j];
      }
    }

    // 구현
    int min = Integer.MAX_VALUE;
    /* 1. 기준에 맞는 x, y, d1, d2 선정. */
    // 기준점
    for (int x = 0; x < N; x++) {
      for (int y = 0; y < N; y++) {
        // 경계의 길이
        for (int d1 = 1; d1 < N; d1++) {
          for (int d2 = 1; d2 < N; d2++) {
            // 범위 필터링 1 ≤ x < x+d1+d2 ≤ N
            if (x + d1 + d2 >= N) continue;
            // 범위 필터링 1 ≤ y-d1 < y < y+d2 ≤ N
            if (y - d1 < 0 || y + d2 >= N) continue;
            min = Math.min(min, solution(x, y, d1, d2));
          }
        }
      }
    }

    System.out.println(min);
  }

  static int solution(int x, int y, int d1, int d2) {
    /* 2. 경계선을 만들면서 5번 선거구 구역 체크 */
    boolean[][] border = new boolean[N][N];

    // 경계선 세팅
    for (int i = 0; i <= d1; i++) {
      border[x + i][y - i] = true;
      border[x + d2 + i][y + d2 - i] = true;
    }

    for (int i = 0; i <= d2; i++) {
      border[x + i][y + i] = true;
      border[x + d1 + i][y - d1 + i] = true;
    }

    /* 3. 경계선을 기준으로 각 구역 인구수 합 구하기 */
    int[] peopleSum = new int[5];
    // 1 구역 인구수
    for (int i = 0; i < x + d1; i++) {
      for (int j = 0; j <= y; j++) {
        if (border[i][j]) break;
        peopleSum[0] += map[i][j];
      }
    }

    // 2 구역 인구수
    for (int i = 0; i <= x + d2; i++) {
      for (int j = N - 1; j > y; j--) {
        if (border[i][j]) break;
        peopleSum[1] += map[i][j];
      }
    }

    // 3 구역 인구수
    for (int i = x + d1; i < N; i++) {
      for (int j = 0; j < y - d1 + d2; j++) {
        if (border[i][j]) break;
        peopleSum[2] += map[i][j];
      }
    }

    // 4 구역 인구수
    for (int i = x + d2 + 1; i < N; i++) {
      for (int j = N - 1; j >= y - d1 + d2; j--) {
        if (border[i][j]) break;
        peopleSum[3] += map[i][j];
      }
    }

    // 5 구역 인구수
    peopleSum[4] = totalPeople- peopleSum[0] - peopleSum[1] - peopleSum[2] - peopleSum[3];

    /* 4. 인구가 가장 많은 선거구와 가장 적은 선거구의 인구 차이를 구하기 */
    Arrays.sort(peopleSum); // 오름차순
    // 최대 - 최소
    return peopleSum[4] - peopleSum[0];
  }
}