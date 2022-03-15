package A1063킹;

import java.io.*;
import java.util.*;

public class A1063킹 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] dir = { "R", "L", "B", "T", "RT", "LT", "RB", "LB" };
    int[] dx = { 1, -1, 0, 0, 1, -1, 1, -1 }; // 알파벳
    int[] dy = { 0, 0, -1, 1, 1, 1, -1, -1 }; // 숫자

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    char[] king = st.nextToken().toCharArray();
    char[] stone = st.nextToken().toCharArray();
    int N = Integer.parseInt(st.nextToken());

    int[] kingPos = { king[0] - 'A', king[1] - '1' };
    int[] stonePos = { stone[0] - 'A', stone[1] - '1' };
    int idx = 0;
    for (int i = 0; i < N; i++) {
      String s = br.readLine(); // 방향 값 

      for (int j = 0; j < 8; j++) { // 일치하는 단어로 방향 찾기
        if (dir[j].equals(s)) idx = j; 
      }

      int[] nextKing = { kingPos[0] + dx[idx], kingPos[1] + dy[idx] }; // 킹의 다음 위치
      if (nextKing[0] < 0 || nextKing[0] >= 8 || nextKing[1] < 0 || nextKing[1] >= 8) continue;

      if (Arrays.equals(nextKing, stonePos)) { // 다음 킹 위치가 돌과 같다면
        int[] nextStone = { stonePos[0] + dx[idx], stonePos[1] + dy[idx] }; // 돌의 다음 위치
        if (nextStone[0] < 0 || nextStone[0] >= 8 || nextStone[1] < 0 || nextStone[1] >= 8) continue;
        stonePos = Arrays.copyOf(nextStone, nextStone.length);
      }
      kingPos = Arrays.copyOf(nextKing, nextKing.length);
    }
    king[0] = (char) (kingPos[0] + 'A');
    king[1] = (char) (kingPos[1] + '1');
    stone[0] = (char) (stonePos[0] + 'A');
    stone[1] = (char) (stonePos[1] + '1');

    System.out.println(king);
    System.out.println(stone);
  }
}
