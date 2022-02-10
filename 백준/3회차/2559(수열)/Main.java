import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		//배열에 넣기
		for (int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int max = 0;
		for (int i = 0 ; i < K; i++) {
			max += arr[i];
		}
		sum = max;
		for (int i = 1 ; i <= N-K; i++) {
			sum -= arr[i-1];
			sum += arr[i+K-1];
			if (sum > max) {
				max = sum;
			}
		}
		System.out.println(max);
		br.close();
	}
}
