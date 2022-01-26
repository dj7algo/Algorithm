package ps;

import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i=0; i<tc; i++) {
			int height = sc.nextInt();
			int room = sc.nextInt();
			int num = sc.nextInt();
			
			int goheight = 0;
			int goroom = 0;
			
			if(num % height==0) {
				if(height == 1) {
					goheight = 1;
					goroom = num;
				}else {
					goheight = height;
					goroom = num/height;
				}
			}else {
				goheight = num % height;
				goroom = num / height +1;
			}
			
			System.out.println(goheight*100 + goroom);
		}
	}
}