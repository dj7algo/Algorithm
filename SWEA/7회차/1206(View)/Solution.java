import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1 ; tc <= 10 ; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0 ; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			//양쪽 2개중에, 가장 큰값을 기준으로 뺀다.
			int jomang = 0;
			for (int i = 2; i < N-2 ; i++) {
				int leftmax = Math.max(arr[i-1], arr[i-2]);
				int rightmax = Math.max(arr[i+1], arr[i+2]);
				int realmax = Math.max(leftmax, rightmax);
				int myfloor = arr[i];
				if (myfloor > realmax) {
					jomang += myfloor-realmax;
				}
			}
			sb.append(jomang).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

}
