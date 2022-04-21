package A11054가장긴바이토닉부분수열;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("A11054가장긴바이토닉부분수열/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++)
      arr[i]=Integer.parseInt(st.nextToken());

    int[] dpU = new int[N];
    int[] dpD = new int[N];

    Arrays.fill(dpU, 1);
    Arrays.fill(dpD, 1);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i] && dpU[j] + 1 > dpU[i])
          dpU[i] = dpU[j] + 1;
      }
    }

    for (int i = N-1; i >= 0; i--) {
      for (int j = N-1; j >= i; j--) {
        if (arr[j] < arr[i] && dpD[j] + 1 > dpD[i])
          dpD[i] = dpD[j] + 1;
      }
    }

    int max = 0;
    for (int i = 0; i < N; i++) {
      if (max < dpU[i] + dpD[i]) 
        max = dpU[i] + dpD[i];
    }

    System.out.println(max - 1);
  }
}