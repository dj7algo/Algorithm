package a0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class 부먹왕국의차원관문 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer ST = new StringTokenizer(br.readLine());
			int townnum = Integer.parseInt(ST.nextToken());
			int limitlen = Integer.parseInt(ST.nextToken());
			int[] town = new int[townnum];
			
			int remain = 0;
			int need = 0;
			
			ST = new StringTokenizer(br.readLine());
			for(int i=0; i<townnum; i++) {
				town[i] = Integer.parseInt(ST.nextToken());
			}
			
			for(int i=0; i<townnum; i++) {
				remain--;
				
				if(town[i]==1)remain = limitlen;
				else {
					if(remain<=0) {
						need++;
						remain = limitlen;
					}
				}
			}
			
			System.out.println("#"+tc+" "+need);
		
		}
		
		
		
	}

}
