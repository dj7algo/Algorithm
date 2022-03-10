package a0310;

import java.util.*;
import java.io.*;

public class 매직스타첫풀이 {

	static int[] usenum = new int[13];		//알파벳 사용 여부 
	static int[][] arr;
	static int[][][] allpair = {			//체크 해야할 모든idx의 쌍
			{{0,4}, {1,3}, {2,2}, {3,1}},
			{{0,4}, {1,5}, {2,6}, {3,7}},
			{{1,1}, {1,3}, {1,5}, {1,7}},
			{{3,1}, {3,3}, {3,5}, {3,7}},
			{{1,1}, {2,2}, {3,3}, {4,4}},
			{{1,7}, {2,6}, {3,5}, {4,4}},
	}; 
	
	static int[][] all = { {0,4}, {1,1}, {1,3}, {1,5}, {1,7}, {2,2}, {2,6}, {3,1}, {3,3}, {3,5}, {3,7}, {4,4}};
	
	static int remain = 12;
	
	static boolean check() {				// 모양 만들어지면 모두 합 26인지 확인 
		
		for(int k=0; k<6; k++) {
			int sum = 0;
			for(int i=0; i<4; i++) {
				int nowi = allpair[k][i][0];	
				int nowj=allpair[k][i][1];
				
				sum+=arr[nowi][nowj];
			}
			System.out.println("sum:"+sum);
			if(sum!=26)return false;
		}
		return true;
	}
	
	static int flag = 0;
	
	static void print() {
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<9; j++) {
				if(arr[i][j]!=0)System.out.print((char)(arr[i][j]+'A'-1));
				else System.out.print('.');
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void findmin(int cnt) {
		
		if(flag==1)return;
		if(cnt==remain ) {
			print();
			if(check())flag = 1;
			return;
		}
		
		
		
		for(int i=0; i<12; i++) {
			int nowi = all[i][0];	int nowj = all[i][1];
			if(arr[nowi][nowj] != 0)continue;
			
			for(int num=1; num<=12; num++) {
				if(usenum[num]==1)continue;
				
				usenum[num] = 1;
				arr[nowi][nowj] = num;
				findmin(cnt+1);
				usenum[num] = 0;
				arr[nowi][nowj] = 0;
			}
		}
		
	}

	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[5][9];
		
		for(int i=0; i<5; i++) {
			String tmp = br.readLine();
			for(int j=0; j<9; j++) {
				char c = tmp.charAt(j);
				
				if(c == 'x' || c=='.')arr[i][j] = 0;
				else {
					arr[i][j] = (c-'A')+1;
					usenum[arr[i][j]] = 1;	//숫자 사용처리 
					remain--;
				}
			}
		}
		
		findmin(0);
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<9; j++) {
				if(arr[i][j]!=0)System.out.print((char)(arr[i][j]+'A'-1));
				else System.out.print('.');
			}
			System.out.println();
		}
	}

}
