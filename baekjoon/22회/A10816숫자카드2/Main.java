package A10816숫자카드2;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("A10816숫자카드2/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 숫자 카드 개수
    int[] arr = new int[N]; // 가지고 있는 숫자카드

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(arr);

    int M = Integer.parseInt(br.readLine()); // 구해야 할 숫자 카드 개수

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < M; i++) {
      int key = Integer.parseInt(st.nextToken()); // 구해야 할 숫자 하나씩

      // upperBound와 lowerBound의 차이 값을 구한다 = 개수
      sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
    }

    System.out.println(sb);
  }

  private static int lowerBound(int[] arr, int key) {
    int lo = 0;
    int hi = arr.length;

    // lo가 hi랑 같아질 때 까지 반복
    while (lo < hi) {
      int mid = (lo + hi) / 2; // 중간위치를 구한다.

      // key 값이 중간 위치의 값보다 작거나 같을 경우 (중복 원소에 대해 왼쪽으로 탐색하도록 상계를 내린다.)
      if (key <= arr[mid]) hi = mid;
      else lo = mid + 1;
    }

    return lo;
  }

  private static int upperBound(int[] arr, int key) {
    int lo = 0;
    int hi = arr.length;

    // lo가 hi랑 같아질 때 까지 반복
    while (lo < hi) {
      int mid = (lo + hi) / 2; // 중간위치를 구한다.

      // key값이 중간 위치의 값보다 작을 경우
      if (key < arr[mid]) hi = mid;
      else lo = mid + 1;
    }

    return lo;
  }

}