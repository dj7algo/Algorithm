package A2606바이러스;

import java.io.*;
import java.util.*;

public class A2606바이러스 {
  static int node[][];
  static boolean virus[];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    node = new int[N][N];
    virus = new boolean[N];
    for (int i = 0; i < m; i++) { // 그래프 구성
      StringTokenizer st =new StringTokenizer(br.readLine()," ");
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;
      node[a][b] = 1; // 앞 뒤 연결 같음
      node[b][a] = 1;
    }
    bfs(0);
  }

  static void bfs(int start) { // BFS 메소드
    Queue<Integer> queue = new LinkedList<>();

    virus[start] = true;
    queue.offer(start);
    int cnt = 0; // 감염 된 컴퓨터의 수
    while (!queue.isEmpty()) {
      int x = queue.poll();

      for (int i = 0; i < node.length; i++) { // 차례대로 1번과 연결 된 컴퓨터들을 찾아 cnt변수 증가
        if (node[x][i] == 1 && !virus[i]) {
          queue.offer(i);
          virus[i] = true;
          cnt++;
        }
      }
    }
    System.out.println(cnt);
  }
}
