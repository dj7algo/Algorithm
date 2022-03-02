package week6;
import java.util.*;
import java.io.*;

public class BJ_14501_퇴사 {
	static int[][] arr;
	static int N;
	static int max = Integer.MIN_VALUE;
	static void recursion(int count, int sum, int before) {
		if (count > N) {
			max = Math.max(sum-before, max);
			return;
		}
		if (count == N) {
			max = Math.max(sum, max);
			return;
		}
		// 더하고 넘기기
		int nextcount =  count + arr[count][0];
		int current = arr[count][1];
		int nextsum = sum+current;
		recursion(nextcount, nextsum, current);
		// 안하고 그냥 다음으로 넘기기
		recursion(count+1, sum, before);
		
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 일수
		arr = new int[N][2];
		for (int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new int[]{ Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		recursion(0,0,0);
		System.out.println(max);
		br.close();
	}
}
