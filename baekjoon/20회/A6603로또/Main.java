package A6603로또;

import java.io.*;

public class Main {
  static int N, arr[];

  public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("A6603로또/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String[] st = br.readLine().split(" ");
      N = Integer.parseInt(st[0]);
      if (N == 0) break;
      
      arr = new int[N];
      for (int i = 1; i < st.length; i++) arr[i-1] = Integer.parseInt(st[i]);
      combination(new int[6] ,0, 0);
      System.out.println();
    }
  }

  private static void combination(int[] result,int cnt, int start) {
    if (cnt == 6) {
      for (int n : result) System.out.print(n+" ");
      System.out.println();
      return;
    }
    for (int i = start; i < N; i++) {
      result[cnt] = arr[i];
      combination(result,cnt + 1, i + 1);
    }
  }
}