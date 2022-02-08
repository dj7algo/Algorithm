package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Baekjun1652 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		char[][] arr = new char[size][size];
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sc.nextLine();
		for(int i=0; i<size; i++) {
			String tmp = sc.nextLine();
			
			for(int j=0; j<size; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		
		sc.close();
		int garo = 0;
		int sero = 0;
		
		for(int i=0; i<size; i++) {
			int jidx = 0;
			
			while(jidx<size) {
				if(arr[i][jidx]=='.') {
					int dotcnt = 0;
					while(jidx<size&&arr[i][jidx]=='.') {
						dotcnt++;
						jidx++;
					}
					
					if(dotcnt>=2)garo++;
					
				}else {
					while(jidx<size&&arr[i][jidx]=='X') {
						jidx++;
					}
				}
			}
		}
		System.out.print(garo + " ");
		
		for(int j=0; j<size; j++) {
			int iidx = 0;
			while(iidx<size) {
				if(arr[iidx][j]=='.') {
					int dotcnt = 0;
					while(iidx<size&&arr[iidx][j]=='.') {
						dotcnt++;
						iidx++;
					}
					if(dotcnt>=2)sero++;
				}else {
					while(iidx<size&&arr[iidx][j]=='X') {
						iidx++;
					}
				}
			}
		}
		System.out.print(sero);
	}

}
