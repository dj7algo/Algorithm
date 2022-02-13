package a0213;

import java.util.*;

public class B2669 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[100][100];
		int[] rec1 = new int[4];
		int[] rec2 = new int[4];
		int[] rec3 = new int[4];
		int[] rec4 = new int[4];
		
		for(int i=0; i<4; i++)rec1[i] = sc.nextInt();
		for(int i=0; i<4; i++)rec2[i] = sc.nextInt();
		for(int i=0; i<4; i++)rec3[i] = sc.nextInt();
		for(int i=0; i<4; i++)rec4[i] = sc.nextInt();
				
		for(int i=rec1[0]; i<rec1[2]; i++) {
			for(int j=rec1[1]; j<rec1[3]; j++) {
				arr[i][j]++;
			}
		}
		
		for(int i=rec2[0]; i<rec2[2]; i++) {
			for(int j=rec2[1]; j<rec2[3]; j++) {
				arr[i][j]++;
			}
		}
		
		for(int i=rec3[0]; i<rec3[2]; i++) {
			for(int j=rec3[1]; j<rec3[3]; j++) {
				arr[i][j]++;
			}
		}
		
		for(int i=rec4[0]; i<rec4[2]; i++) {
			for(int j=rec4[1]; j<rec4[3]; j++) {
				arr[i][j]++;
			}
		}
			
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j]!=0)cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
