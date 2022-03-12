package a0312;

import java.util.*;
import java.io.*;


/*
 가로로 행 바꿔가면서 체크 
 세로로 열 바꿔가면서 체크 
 -> 인접부분에 다른원소있으면 값 바꾼후 배열 복사해서 파라미터로 넘겨줌
 -> 가로, 세로로 둘다 체크 가장 큰값 전역변수로 저장 
 -> 전역변수 출력 
 */

public class 백준3085사탕게임 {

	static char[][] arr;
	static int maxnum = 1;
	static int size; 
	
	
	static void maxfind() {
		int cnt = 0;
		
		//for(char[] tmp:arr)System.out.println(tmp);
		
		
		for(int i=0; i<size; i++) {
			cnt = 1;
			for(int j=0; j<size-1; j++) {
				if(arr[i][j] == arr[i][j+1])cnt++;
				else {
					maxnum = Math.max(maxnum, cnt);
					cnt = 1;
				}
			}
			maxnum = Math.max(maxnum, cnt);
		}
		
		for(int i=0; i<size; i++) {
			cnt = 1;
			for(int j=0; j<size-1; j++) {
				if(arr[j][i] == arr[j+1][i])cnt++;
				else {
					maxnum = Math.max(maxnum, cnt);
					cnt = 1;
				}
			}
			maxnum = Math.max(maxnum, cnt);
		}
		//System.out.println(maxnum);
		//System.out.println();
	}
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		
		arr = new char[size][size];
		
		for(int i=0; i<size; i++) {
			String tmp = br.readLine();
			for(int j=0; j<size; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size-1; j++) {
				if(arr[i][j]!=arr[i][j+1]) {
					char tmp = arr[i][j];
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = tmp;
					maxfind();
					arr[i][j+1] = arr[i][j];
					arr[i][j] = tmp;
				}
			}
		}
		
		for(int i=0; i<size-1; i++) {
			for(int j=0; j<size; j++) {
				if(arr[i][j]!=arr[i+1][j]) {
					char tmp = arr[i][j];
					arr[i][j] = arr[i+1][j];
					arr[i+1][j] = tmp;
					maxfind();
					arr[i+1][j] = arr[i][j];
					arr[i][j] = tmp;
				}
			}
		}
		
		System.out.println(maxnum);
		
	}

}
