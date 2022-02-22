package a0222;

import java.util.*;
public class 백준13458_시험감독 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int roomnum = sc.nextInt();
		int[] room = new int[roomnum];
		for(int i=0; i<roomnum; i++)room[i]=sc.nextInt();
		
		int headcoach = sc.nextInt();
		int coach = sc.nextInt();
		long result = 0;
		
		
		for(int i=0; i<roomnum; i++) {
			room[i]-=headcoach;
			if(room[i]<0)room[i] = 0;
		}
		result+=roomnum;
		
		for(int i=0; i<roomnum; i++) {
			if(room[i]==0)continue;
			
			if(room[i]%coach==0)result+=(room[i]/coach);
			else result+=(room[i]/coach+1);
		}
		System.out.println(result);
	}

}
