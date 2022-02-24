package a0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백만장자프로젝트 {

	static int[] price;
	static int day;
	
	static int maxfind(int startidx) {
		int max = 0;
		int maxidx = 0;
		
		for(int i=startidx; i<day; i++) {
			if(max<price[i]) {
				max = price[i];
				maxidx = i;
			}
		}
		return maxidx;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			day = Integer.parseInt(br.readLine());
			StringTokenizer ST = new StringTokenizer(br.readLine());
			
			price = new int[day];
			for(int i=0; i<day; i++) {
				price[i] = Integer.parseInt(ST.nextToken());
			}
			
			long sum = 0;
			int idx = 0;
			while(idx<day) {
				int nowmaxidx = maxfind(idx);
				
				for(int i=idx; i<nowmaxidx; i++) {
					sum+=(price[nowmaxidx]-price[i]);
				}
				idx = nowmaxidx+1;
			}
			System.out.println("#"+tc+" "+sum);
		}

	}

}
