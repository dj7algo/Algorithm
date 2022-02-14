package week4;
import java.util.*;
import java.io.*;
public class 수이어가기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(4);
			System.out.println("1 1 0 1");
		}else {
			int max = -1;
			int maxIdx = 0;
			for(int i = 1 ; i <= N; i++ ) {
				int count = 2;
				int second = N-i;
				int third = N-second;
//				System.out.println(second + "<>" +third);s
				while(third >= 0) {
					int temp = second;
					second = third;
					third = temp-third;
					count++;
				}
				if (max <= count) {
					max = count;
					maxIdx = i;
				}else {
					//출력
					System.out.println(max);
					int before = N;
					int res = N - maxIdx;
					System.out.print(before + " " + res + " ");
					while(res >= 0) {
						int temp = before;
						before = res;
						res = temp-before;
						if (res < 0) break;
						System.out.print(res + " ");
					}
					break;
				}
				
			}
		}
		
	}
}
