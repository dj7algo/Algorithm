package A21608상어초등학교;

import java.io.*;
import java.util.*;

public class Main {
  static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
  static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("A21608상어초등학교/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[][] map = new int[N][N];
    int[] student = new int[N * N]; // 0 ~ N*N
    ArrayList<ArrayList<Integer>> like = new ArrayList<>(); // 1 ~ N*N+1
    for (int i = 0; i < N * N + 1; i++)
      like.add(new ArrayList<Integer>());

    // 입력
    for (int i = 0; i < student.length; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      student[i] = Integer.parseInt(st.nextToken());
      for (int j = 0; j < 4; j++) {
        like.get(student[i]).add(Integer.parseInt(st.nextToken()));
      }
    }

    // 구현
    // 1. 자리배치 
    for (int idx = 0; idx < student.length; idx++) { // 학생수만큼 반복
      int ty = -1, tx = -1;
      int max = -1; // 좌석점수(score)가 가장 최고인 자리 저장할 변수
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] != 0)
            continue;

          // <좌석점수>
          int score = 0;
          for (int k = 0; k < 4; k++) {
            int x = i + dx[k]; // 인접한 좌석
            int y = j + dy[k];
            if (x < 0 || y < 0 || x >= N || y >= N) continue;
            if (like.get(student[idx]).contains(map[x][y])) // 선호하는 학생이 있을 때
              score += 5;
            else if (map[x][y] == 0) // 빈자리일 때
              score += 1;
          }

          if (score > max) {
            tx = i;
            ty = j;
            max = score;
          }
        }
      }
      
      // 좌석 점수가 가장 큰 곳에 학생 배치
      map[tx][ty] = student[idx];
    }

    // 2. 학생만족도
    int result = 0; // 결과값, 인접한 학생수
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int count = 0;

        for (int k = 0; k < 4; k++) {
          int x = i + dx[k];
          int y = j + dy[k];
          if (x < 0 || y < 0 || x >= N || y >= N)
            continue;
          // 선호하는 학생이 있을 때
          if (like.get(map[i][j]).contains(map[x][y]))
            count++;
        }

        // 0 - 0점 , 1 - 1점, 2 - 10점, 3 - 100점, 4 - 1000점
        if (count != 0)
          result += (int) Math.pow(10, count - 1); // 10^(인접하는 좋아하는 학생수 -1)

      }
    }

    // 출력
    System.out.println(result);

    br.close();
  }
}