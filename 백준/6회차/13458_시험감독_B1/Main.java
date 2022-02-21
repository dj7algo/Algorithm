import java.util.*;
import java.io.*;

class Main{
	static int n,b,c;
	static int arr[];
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());	// 시험장의 개수
		// 각 시험장마다 총 감독관은 1명 있어야 되고 부감독관은 여러명 있어도 된다
		
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		b = Integer.parseInt(st.nextToken());	// 총감독관 커버
		c = Integer.parseInt(st.nextToken());	// 부감독관 커버
		
		long ans = 0;
		// 각 시험장 순회
		for(int i=0; i<n; i++) {
			int num = arr[i];
			
			// 총감독관 자리
			num-=b;
			ans++;
			
			if(num > 0) {	// 부 감독관이 필요할때
				ans+=num/c;
				int tmp = num%c;
				if(tmp!=0) ans++;	
			}
		}		
		System.out.println(ans);
	}
}
