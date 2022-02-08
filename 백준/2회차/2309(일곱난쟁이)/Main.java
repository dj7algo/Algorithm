import java.io.*;
import java.util.*;

public class Main {
	static int arr[] = new int[9];
	static int res[] = new int[7];
	//재귀함수 구현
	static void find7(int cnt, int start) {
		if (cnt == 7) { // base case
			int sum = 0;
			for(int i = 0 ; i < res.length; i++) {
				sum += res[i];
			}
			if (sum == 100) { 
				//정렬
				Arrays.sort(res);
				//출력
				for(int i = 0 ;i < res.length; i++) {
					System.out.println(res[i]);
				}
			}
		}else { // recursive case
			for (int i = start ; i < 9; i++) {
				res[cnt] = arr[i];
				find7(cnt+1, i+1);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0 ; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//조합활용. 9개중에 7개 뽑기
		find7(0,0);
		br.close();
		
	}
}
