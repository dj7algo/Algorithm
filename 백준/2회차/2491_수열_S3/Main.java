import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		
		String [] input = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		

		int  left[] = new int[n];
		int right [] = new int[n];
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);
		
		// 오르막 -> 왼쪽에서 부터
		// 내리막 -> 오른쪽에서 부터 왼쪽이랑 똑같이 하면 내리막이 됨
		
		for(int i=1; i<n; i++) {
			if(arr[i-1] <= arr[i]) left[i] = left[i-1]+1;
		}
		
		for(int i=n-2; i>=0; i--) {
			if(arr[i] >= arr[i+1]) right[i] = right[i+1]+1;
		}
		
		int max = 0;
		for(int i=0; i<n; i++){
			max = Math.max(max, Math.max(left[i], right[i]));
		}
		System.out.println(max);
	}
 }
