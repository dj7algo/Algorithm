package A0209;

import java.util.*;
/*
 배열을 이용하여 색종이별로 수를 입력
 배열 돌면서 0인지 아닌지 검사 
 */
public class 색종이2563 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[][] arr = new int[100][100];
		
		for(int tc=1; tc<=num; tc++) {
			int lx = sc.nextInt();
			int ly = sc.nextInt();
			int rx = lx+10;
			int ry = ly+10;
			
			for(int i=lx; i<rx; i++) {
				for(int j=ly; j<ry; j++) {
					arr[i][j]++;
				}
			}
		}
		
		int sum = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j]!=0)sum++;
			}
		}
		System.out.println(sum);
	}
}
