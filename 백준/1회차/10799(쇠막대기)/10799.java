package ps;

import java.io.*;
import java.util.*;

public class ps2 {

	public static void main(String[] args) throws Exception {
		
		// ")"가 나오면 -> 1. 바로직전에 "("인경우, 2. ")"인경우 
			
		// 1. 레이저 쏘기 -> 잘린막대 개수에 지금까지 센 막대 개수를 더함
		
		// 2. 막대가 끝나는 지점 -> 지금까지 센 막대개수-1, 잘린막대 개수+1
		
		int result = 0;		// 잘린막대 개수 
		
		int now_num = 0; 	// 현재 안잘린 막대 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]=='(')now_num++;
			else if(arr[i]==')') {
				if(arr[i-1]=='(') {
					now_num--;
					result+=now_num;					
				}else if(arr[i-1]==')'){
					result++;
					now_num--;
				}
			
			}
		}
		System.out.println(result);
	}
}
