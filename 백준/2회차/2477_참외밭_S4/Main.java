import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 문제풀이 전략
		// 1. 전체 사각형의 넓이를 구한다 (가장 긴 가로 x 가장 긴 세로)
		// 2. 전체 사각형에서 옴폭 들어간 부분을 뺀다
		// 3. 빼야할 사각형의 넓이를 구하는 방법은 가장 긴 가로, 세로 앞뒤에 있는걸 빼면 된다
		// 4. 입력은 가로 한번 세로한번 들어오므로  가장 긴세로의 인덱스가 1이라면 arr[0]-arr[3]을 하면 값을 구할수있음 
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[6];
		
		int max_h=0;
		int max_w =0;
		int max_h_idx =0;
		int max_w_idx = 0;
		for(int i=0; i<6; i++) {
			String [] input = br.readLine().split(" ");
			int dir = Integer.parseInt(input[0]);
			int len = Integer.parseInt(input[1]);
			
			arr[i] = len;
			
			if(dir==3 || dir==4) {
				if(max_h < len) {
					max_h = len;
					max_h_idx = i;
				}
			}
			else {
				if(max_w < len) {
					max_w = len;
					max_w_idx = i;
				}
			}
		}

		int sum = 0;
		
		
		sum+=max_w * max_h;
		int tmp = 0;				// 세로길이 구하기
		if(max_w_idx ==0) {
			tmp = Math.abs(arr[1]-arr[5]);
		}
		else if(max_w_idx ==5) {
			tmp = Math.abs(arr[0]-arr[4]);
		}
		else {
			tmp = Math.abs(arr[max_w_idx-1]-arr[max_w_idx+1]);
		}
		
		int tmp2 = 0;
		if(max_h_idx==0) {			// 가로길이 구하기
			tmp2 = Math.abs(arr[1]-arr[5]);
		}
		else if(max_h_idx==5) {
			tmp2= Math.abs(arr[0]-arr[4]);
		}
		else {
			tmp2 = Math.abs(arr[max_h_idx-1]-arr[max_h_idx+1]);
		}

		sum-=(tmp*tmp2);
		System.out.println(sum*n);
	}
 }
