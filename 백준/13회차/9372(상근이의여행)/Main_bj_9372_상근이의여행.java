package week13;
import java.util.*;
import java.io.*;
public class Main_bj_9372_상근이의여행 {
	
	static int BFS(int N, int M, int start, List<Integer>[] graph) {
		
		boolean[] visited = new boolean[N];
		Queue<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		q.add(start);
		int len = 0;
		while (!q.isEmpty()) {
			int V = q.poll();
			for (int i = 0 ; i < graph[V].size(); i++) {
				if (!visited[graph[V].get(i)]) {
					visited[graph[V].get(i)] = true;
					q.add(graph[V].get(i));
					len++;
				}
			}
		}


		return len;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N개국 여행 자아찾기
		// 적은 종류의 비행기를 타고 국가들 이동
		// 비행 스케쥴이 주어졌을 때, 상근이가 가장 적은 종류의 비행기를타고 모든 국가들을 여행하게
		// 상근이가 한 국가에서 다른국가로 이동할때, 다른국가를 거쳐가도 됨.
		// 그냥 무조건 가장 적은종류의 비행기를 타면댐
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0 ; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); //VERTEX 수
			int M = Integer.parseInt(st.nextToken()); //간선 수
			List<Integer>[] graph = new LinkedList[N];
			for (int i = 0 ; i < N; i++) {
				graph[i] = new LinkedList<Integer>();
			}
			for (int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken())-1; //그래프는 0부터 시작하므로 1빼기
				int Y = Integer.parseInt(st.nextToken())-1; //그래프는 0부터 시작하므로 1빼기
				//양방향 그래프
				graph[X].add(Y); 
				graph[Y].add(X);
			}

			int min = BFS(N,M,0,graph);
			System.out.println(min);
		}
		
		
		
		br.close();
	}
}
