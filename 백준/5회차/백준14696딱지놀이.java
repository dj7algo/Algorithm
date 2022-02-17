package a0217;

import java.util.*;

public class 백준14696딱지놀이 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i=0; i<tc; i++) {
			int acnt = sc.nextInt();
			int[] a = new int[5];
			for(int j=0; j<acnt; j++)a[sc.nextInt()]++;
			
			int bcnt = sc.nextInt();
			int[] b = new int[5];
			for(int j=0; j<bcnt; j++)b[sc.nextInt()]++;
				
			for(int k=4; k>=1; k--) {
				if(a[k]>b[k]) {
					System.out.println("A");
					break;
				}
				else if(a[k]<b[k]) {
					System.out.println("B");
					break;
				}
				else if(a[k]==b[k]&&k==1) {
					System.out.println("D");
					break;
				}
			}
				
		}
		
	}
}
