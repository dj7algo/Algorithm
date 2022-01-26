package ps;

import java.util.*;

public class ps3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int str1len = sc.nextInt();
		int str2len = sc.nextInt();
		
		char[] newarr = new char[str1len + str2len];
		
		String str1 = sc.next();
		String str2 = sc.next();
		
		int time = sc.nextInt();
		
		for(int i=0; i<str1len; i++) {
			int move = time-i;
			if(move<0)move=0;
			else if(move>str2len)move=str2len;
			
			int newidx = (str1len-1-i)+move;
			
			newarr[newidx] = str1.charAt(i); 
		}
		
		for(int i=0; i<str2len; i++) {
			int move = time-i;
			if(move<0)move=0;
			else if(move>str1len)move=str1len;
			
			int newidx = (str1len+i)-move;
			newarr[newidx] = str2.charAt(i);
		}
		
		for(int i=0; i<newarr.length; i++) {
			System.out.print(newarr[i]);
		}
	}
}
