package ps;

import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();					//test case 입력
		
		for(int i=0; i<tc; i++) {
			int height = sc.nextInt();			//건물의 층수 입력
			int room = sc.nextInt();			//층당 호수 입력
			int num = sc.nextInt();				//몇번째 손님인지 입력 
			
			int goheight = 0;				//배정될 층수
			int goroom = 0;					//배정될 호수 
			
			if(num % height==0) {				// (고객수 % 층수)의 나머지 연산이 0일때 
				if(height == 1) {			// 나머지가 0이면서 건물 높이가 1일때
					goheight = 1;
					goroom = num;
				}else {					// 나머지가 0이면서 고객이 꼭대기 층에 배정될때 
					goheight = height;
					goroom = num/height;
				}
			}else {						// 일반적인 경우 
				goheight = num % height;
				goroom = num / height +1;
			}
			
			System.out.println(goheight*100 + goroom);
		}
	}
}
