package A1446지름길;

import java.io.*;
import java.util.*;

public class Main {

  static class Node implements Comparable<Node> {
    int s,e, length; // 시작, 끝, 길이
    Node(int s, int e, int length) {
      this.s = s;
      this.e = e;
      this.length = length;
    }

    @Override
    public int compareTo(Node o) {
      return (this.s == o.s) ? this.e - o.e : this.s - o.s;
    }
  }

  public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("A1446지름길/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken()); // 지름길의 개수
    int D = Integer.parseInt(st.nextToken()); // 고속도로의 길이

    ArrayList<Node> graph = new ArrayList<Node>(); 
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int s = Integer.parseInt(st.nextToken()); // 지름길 시작
      int e = Integer.parseInt(st.nextToken()); // 지름길 끝
      int l = Integer.parseInt(st.nextToken()); // 지름길 길이
      if (e > D || e - s <= l) continue; // 역주행X, 기존 고속도로보다 시간이 더 오래걸릴 경우
      graph.add(new Node(s, e, l));
    }
    
    Collections.sort(graph);

    int idx = 0, move = 0;
    int[] dist = new int[10001]; // 1씩 증가하면서 검토
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;

    // 구현
    while (move < D) {
      if (idx < graph.size()) {
        Node node = graph.get(idx); // 가장 가까운 지름길부터 하나씩 get
        if (move == node.s) { 
          dist[node.e] = Math.min(dist[node.e], dist[move] + node.length);
          idx++;
        } else { // 지름길을 타지 않고 그냥 이동하는 경우
          dist[move + 1] = Math.min(dist[move] + 1, dist[move + 1]);
          move++;
        }
      } else { // 지름길을 전부 확인 후 남은 길이 있으면
        dist[move + 1] = Math.min(dist[move] + 1, dist[move + 1]);
        move++;
      }
    }

    // 결과
    System.out.println(dist[D]);
  }
}