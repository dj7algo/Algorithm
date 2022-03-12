package a0312;

import java.util.*;
import java.io.*;

public class 백준2784가로세로퍼즐 {

	static String[] arr;
	static int[] result;
	static int visit[];		//순열 만드는 용도 
	static char[][] ch;
	static int[] visit2;	//전체 문자열과 비교하는 용도
	
	static boolean check() {
		
		ch = new char[3][3];
		
		for(int i=0; i<3; i++) {
			int idx = result[i];
			String tmp = arr[idx];
			for(int j=0; j<3; j++) {
				ch[i][j] = tmp.charAt(j);
			}
		}
		
		//for(char[] tmp: ch)System.out.println(tmp);
		
		
		for(int i=0; i<3; i++) {
			String tmp = "";
			for(int k=0; k<3; k++) {
				tmp+=Character.toString(ch[i][k]);
				for(int j=0; j<6; j++) {
					if(visit2[j]==0 && arr[j].equals(tmp)) {
						visit2[j] = 1;
						break;
					}
				}
			}
		}
		
		//System.out.println(Arrays.toString(visit2));
		
		for(int i=0; i<3; i++) {
			String tmp = "";
			for(int k=0; k<3; k++) {
				tmp+=Character.toString(ch[k][i]);
				for(int j=0; j<6; j++) {
					if(visit2[j]==0 && arr[j].equals(tmp)) {
						visit2[j] = 1;
						break;
					}
				}
			}
		}
//		System.out.println(Arrays.toString(visit2));
//		System.out.println();
		for(int i=0; i<6; i++) {
			if(visit2[i]==0)return false;
		}
		return true;
	}
	
	static int finish = 0;
	
	static void permutation(int cnt) {
		
		if(finish==1)return;
		if(cnt==3) {
			visit2 = new int[6];
			if(check())finish=1;
			return;
		}
		
		for(int i=0; i<6; i++) {
			if(visit[i]==0) {
				visit[i] = 1;
				result[cnt] = i;
				permutation(cnt+1);
				visit[i] = 0;
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new String[6];
		visit = new int[6];
		result = new int[6];
		
		for(int i=0; i<6; i++) {
			arr[i] = br.readLine();
		}
		
		permutation(0);
		
		if(finish==1) {
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					System.out.print(ch[i][j]);
				}
				System.out.println();
			}
		}else System.out.println(0);
		
		
		
	}

}
