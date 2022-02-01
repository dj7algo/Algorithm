package ps;

import java.util.Arrays;
import java.util.Scanner;

public class B1475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int roomnum = sc.nextInt();
		
		int nums[] = new int[10];
		
		while(roomnum !=0) {
			
			nums[roomnum%10]++;
			roomnum/=10;
		}
		
		int sncnt = 0;
		int maxcnt = -1;
		
		for(int i=0; i<10; i++) {
			if(i==6 || i==9) {
				sncnt+=nums[i];
				continue;
			}
			if(nums[i]>maxcnt)maxcnt = nums[i];
		}
		
		if(sncnt%2==0)sncnt/=2;
		else sncnt=sncnt/2 +1;
		
		if(sncnt > maxcnt)System.out.println(sncnt);
		else System.out.println(maxcnt);
	}
}
