package A10816숫자카드2;

import java.io.*;
import java.util.*;

public class TimeOver {
  public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("A10816숫자카드2/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 숫자 카드 개수
    String[] arr1 = br.readLine().split(" "); // 가지고 있는 숫자카드
    int M = Integer.parseInt(br.readLine()); // 구해야 할 숫자 카드 개수
    String[] arr2 = br.readLine().split(" "); // 개수를 구해야할 숫자 카드

    for (int i = 0; i < M; i++) {
      sb.append(Collections.frequency(Arrays.asList(arr1), arr2[i]) + " ");
    }

    System.out.println(sb.toString().trim());
  }
}