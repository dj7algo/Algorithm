package test_for_test;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/test_for_test/newinput2.txt"));
		Scanner sc = new Scanner(System.in);
		int N1 = sc.nextInt();
		int N2 = sc.nextInt();
		// right : 1 , left: 0
		int[] direction = new int[26];
		char[] line = new char[N1+N2];
		String rightst = sc.next();
		for (int i = 0 ; i < N1; i++) {
			direction[rightst.charAt(i) - 'A'] = 1;
			line[i] = rightst.charAt(N1-i-1);
		}
		String leftst = sc.next();
		for (int i = 0 ; i< N2; i++) {
			direction[leftst.charAt(i)-'A'] = -1;
			line[i+N1] = leftst.charAt(i);
		}
		int loop = sc.nextInt();
		
		for (int i = 0 ; i < loop; i++) {
			char[] templine = new char[N1+N2];
			for (int j = 0 ; j < line.length ; j++) {
				int mydirect = direction[line[j]-'A']; // 내 방향
				int nextIndex = j + mydirect;//내 앞에 개미의 index
				//개미 인덱스 유효검사
				if( nextIndex < 0 || nextIndex >= line.length) {
					templine[j] = line[j];
					continue;
				}
				int nextdirect = direction[line[nextIndex]-'A'];//내 앞개미의 방향
//				System.out.println(j + " " + mydirect + " " + nextdirect);
				if (nextdirect != mydirect) {
					//swap
					templine[nextIndex] = line[j]; //개미와
					templine[j] = line[nextIndex]; //다음개미를 교환
				}else{
					templine[j] = line[j]; // 방향이 같으면, 그냥 가만히있음.
				}
//				System.out.println(templine);
			}
			line = templine;
//			System.out.println(templine);
			
		}
		StringBuilder sb = new StringBuilder();
		for(char c : line) {
			sb.append(c);
		}
		System.out.println(sb);

	}
}