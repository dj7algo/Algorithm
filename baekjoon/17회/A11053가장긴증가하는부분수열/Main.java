package A11053가장긴증가하는부분수열;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("A11053가장긴증가하는부분수열/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int[] dp = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.fill(dp, 1);
    for (int i = 0; i < N; i++) {
      for(int j=0;j<i; j++){
        if(arr[j]<arr[i] && dp[j]+1>dp[i]) dp[i]=dp[j]+1;
      }
    }
    
    int max=-1;
    for(int i=0;i<N;i++){
        max = Math.max(dp[i], max);
    }

    System.out.println(max);
  }
}