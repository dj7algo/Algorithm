package test_for_test;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src/test_for_test/newinput2.txt"));
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for ( int i = 0 ; i < testcase; i++) {
			int floor = sc.nextInt();
			int room = sc.nextInt();
			int rank = sc.nextInt();
			int[][] arr = new int[room][floor];
			int num = 0;
			//배열생성해서 배열인덱스 이용해서 개수새기
			for (int a = 0 ; a < room ; a++) {
				for (int b= 0 ; b < floor; b++) {
					num++;
					if (num == rank) {
						System.out.println( ((b+1)*100) + (a+1));
						break;
					}
				}
			}
//			System.out.println(floor + " " + room + " " + rank);
		}
		

	}
}