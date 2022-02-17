package a0217;

import java.util.*;
public class 백준10163색종이 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int recnum = sc.nextInt();
		
		int[][] rec = new int[recnum][4];
		
		for(int i=0; i<recnum; i++) {
			for(int j=0; j<4; j++) {
				rec[i][j] = sc.nextInt();
			}
		}
		
		int[][] std = new int[1001][1001];
		
		for(int i=0; i<recnum; i++) {	
			for(int j=rec[i][0]; j<rec[i][0]+rec[i][2]; j++) {
				for(int k=rec[i][1]; k<rec[i][1]+rec[i][3]; k++) {
					std[j][k] = i+1;
				}
			}
		}
		
		for(int k=1; k<=recnum; k++) {
			int sum = 0;
			for(int i=0; i<1001; i++) {
				for(int j=0; j<1001; j++) {
					if(std[i][j]==k)sum++;
				}
			}
			System.out.println(sum);
		}
		
		//for(int[] a: std)System.out.println(Arrays.toString(a));
		
	}

}
