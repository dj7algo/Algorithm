package A18352특정거리의도시찾기;

import java.io.*;
import java.util.*;

public class Main {

  static class Node {// 다음 노드의 인덱스와, 그 노드로 가는데 필요한 거리.
    int idx, cost;

    Node(int idx, int cost) {
      this.idx = idx;
      this.cost = cost;
    }
  }

  public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("A18352특정거리의도시찾기/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    // 입력
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int N = Integer.parseInt(st.nextToken()); // 도시의 개수(노드)
    int M = Integer.parseInt(st.nextToken()); // 도로의 개수(간선)
    int K = Integer.parseInt(st.nextToken()); // 거리 정보
    int X = Integer.parseInt(st.nextToken()); // 출발 도시 정보

    ArrayList<Node>[] graph = new ArrayList[N+1];
    for (int i = 1; i < N+1; i++) graph[i]=new ArrayList<Node>(); // 0은 임의, 1부터 시작하기 때문에
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int s = Integer.parseInt(st.nextToken()); // 시작
      int e = Integer.parseInt(st.nextToken()); // 끝
      graph[s].add(new Node(e,1));  // 거리들은 모두 1
    }

    int[] dist = new int[N + 1]; // 최소 거리을 저장할 배열
    for (int i = 1; i < N + 1; i++) dist[i] = Integer.MAX_VALUE;
    
    // 구현
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(X,0)); // 시작-시작, 거리 0
    dist[X] = 0;

    while (!q.isEmpty()) {
      Node node = q.poll();

      for (int i = 0; i < graph[node.idx].size(); i++) { // 선택된 노드의 모든 주변 노드를 수만큼 반복
        Node nxtNode = graph[node.idx].get(i); // 인접 노드 하나 get
        if (dist[nxtNode.idx] > node.cost + 1) { // 인접 노드 더한값이 기존보다 더 최소라면
          dist[nxtNode.idx] = node.cost + 1;
          q.offer(new Node(nxtNode.idx, dist[nxtNode.idx])); // 갱신된 경우에만 큐에 넣는다.
        }
      }
    }

    // 결과
    for (int i = 1; i < N + 1; i++) 
      if (dist[i] == K) sb.append(i + "\n"); // K만큼의 거리가 있으면 출력
    
    if (sb.toString().trim().length() == 0) sb.append(-1);

    System.out.println(sb.toString().trim());
  }
}