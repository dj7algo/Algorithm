package week11;
import java.util.*;
import java.io.*;
public class Main_bj_2606_바이러스 {
	static int res = 0;
	static List<Integer>[] list;
	static boolean[] visited;
	static void find(int number) {
		for (int i = 0 ; i < list[number].size(); i++) {
			int index = list[number].get(i);
			if(!visited[index]) {
				visited[index] = true;
				find(index);
				res++;
			}
			
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int edgeN = Integer.parseInt(br.readLine());
		list = new ArrayList[N];
		for (int i = 0 ; i < N ; i++) {
			list[i] = new ArrayList<Integer>();
		}
		visited = new boolean[N];
		for (int i = 0 ; i < edgeN ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1 ;
			int y = Integer.parseInt(st.nextToken()) - 1 ;
			list[x].add(y);
			list[y].add(x);
		}
		visited[0] = true;
		find(0);
		System.out.println(res);
		br.close();
	}
}
