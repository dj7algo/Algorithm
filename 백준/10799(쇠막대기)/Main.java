package test_for_test;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/test_for_test/newinput2.txt"));
		Scanner sc = new Scanner(System.in);
		String line = sc.next();
		List<Integer> stack = new ArrayList<>();
		int result = 0;
		char lasttok ='(';
		for (int i = 0 ; i < line.length(); i++) {
			char input = line.charAt(i);
			if (input == '(') {
				stack.add(0);
			}else { // input이 )일때
				if(stack.size() != 0 ) { //만약 스택에 (이 들어있으면 스택에서 빼내면서 스택안에 있는 애들을 다 더해주고 뺴낸다.
					stack.remove(stack.size()-1);// 스택에 있던 (를 꺼내면서
					if (lasttok != ')'){
						result+=stack.size();
					}else {
						result++;
					}

				}
			}
			lasttok = input;
		}
		System.out.println(result);

	}
}