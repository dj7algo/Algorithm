package A1654랜선자르기;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("A1654랜선자르기/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
    int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

    int[] arr = new int[K]; // 랜선 길이
    for (int i = 0; i < K; i++) arr[i] = Integer.parseInt(br.readLine());
        
    Arrays.sort(arr);
    long max = arr[K-1];
    long min = 1;
    long middle = 0;

    while (max >= min) { // 이분탐색 시작
      middle = (max + min) / 2;

      long count = 0; // 중간값으로 나눴을 때의 랜선의 개수
      for (int i = 0; i < arr.length; i++) count += arr[i] / middle;

      // 범위를 점점 좁히는 것. min == max 일치할 때 -> 그 다음 반복에서 min이 더 큰값으로 반복문 종료
      if (count >= N) {
        min = middle + 1;
      } else if (count < N) {
        max = middle - 1;
      }
    }
    
    System.out.println(max);
  }
}