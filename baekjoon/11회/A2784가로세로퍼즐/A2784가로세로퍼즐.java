package A2784가로세로퍼즐;

import java.io.*;
import java.util.*;

public class A2784가로세로퍼즐 {
  private static boolean[] visited; // 방문 기록
  private static List<String> word; // 문자열 저장

  private static List<List<String>> list = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    word = new ArrayList<>();
    visited = new boolean[6];
    for (int i = 0; i < 6; i++) word.add(reader.readLine());

    per(new int[3], 0, 3);

    if (list.isEmpty()) sb.append(0);
    else {
      for (int i = 0; i < 3; i++) {
        sb.append(list.get(0).get(i)).append("\n");
      }
    }

    System.out.println(sb);
  }
  // 순열
  private static void per(int[] ans, int cnt, int R) {
    if (cnt == R) {
      // 3개 다 뽑은 경우
      List<String> temp = new ArrayList<>(3);
      List<String> copy = new ArrayList<>(6);
      copy.addAll(word); // 모든 단어들을 copy에 저장

      // 뽑은 3개 단어 넣기
      for (int i = 0; i < 3; i++) {
        temp.add(word.get(ans[i]));
        copy.remove(word.get(ans[i]));
      }

      // 퍼즐이 성립하는지 비교
      for (int i = 0; i < 3; i++) {
        String tempStr = "" +
            temp.get(0).charAt(i) +
            temp.get(1).charAt(i) +
            temp.get(2).charAt(i);

        if (copy.contains(tempStr)) copy.remove(tempStr); // 가로세로 단어들 비교했을때 같은 단어가 있다면 똑같은 단어 copy에서 제거
        else return;
      }
      list.add(temp);

      return;
    }

    for (int i = 0; i < 6; i++) {
      if (visited[i]) continue;
        visited[i] = true;
        ans[cnt] = i;
        per(ans, cnt + 1, R);
        visited[i] = false;
    }
  }

}