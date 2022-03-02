package week8;
import java.util.*;
import java.io.*;
public class Main_bj_1026_보물 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> A = new PriorityQueue<Integer>();
		PriorityQueue<Integer> B = new PriorityQueue<Integer>((o1, o2)-> {
			return o2-o1;
		});
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0 ; i < N; i++) {
			A.offer(Integer.parseInt(st.nextToken())); //A
			B.offer(Integer.parseInt(st2.nextToken())); //B
		}
		int min = 0;
		for (int i = 0 ; i < N; i++) {
			min += A.poll() * B.poll();
		}
		System.out.println(min);
		br.close();
	}
}
