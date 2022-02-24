package a0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class View {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc=1; tc<=10; tc++) {
			int tower = Integer.parseInt(br.readLine());
			
			int[] len = new int[tower];
			StringTokenizer	ST = new StringTokenizer(br.readLine());
			for(int i=0; i<tower; i++) {
				len[i] = Integer.parseInt(ST.nextToken());
			}
			int sum = 0;
			for(int i=0; i<tower; i++) {
				
				int maxlen = 0;
				for(int j=i-2; j<=i+2; j++) {
					if(j<0 || j>=tower || j==i)continue;
					maxlen = Math.max(maxlen, len[j]);
				}
				if(maxlen<len[i])sum+=len[i]-maxlen;
			}
			System.out.println("#"+tc+" "+sum);
		}
	}

}
