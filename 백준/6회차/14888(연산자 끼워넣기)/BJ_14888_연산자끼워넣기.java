package week6;
import java.util.*;
import java.io.*;

public class BJ_14888_연산자끼워넣기 {
	static boolean[] isSelected; // 순열용
	static int result[]; //순열
	static int N; //피연산자수 합
	static int K; //연산자수 합
	static List<Character> operator;
	static int[] arr;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int calc(int a, int b, char oper) {
		//연산자 , 피연산자 a b
		int result = 0;
		switch(oper) {
		case '+': result = a+b; break;
		case '-': result = a-b; break;
		case '*': result = a*b; break;
		case '/': result = a/b; break;
		}
		return result;
	}
	static void perm(int count) {
		if (count == K) {
			int before = arr[0];
			for (int i = 0 ; i < K; i++) {
				before = calc(before, arr[i+1],operator.get(result[i]));
			}
			min = Math.min(before, min);
			max = Math.max(before, max);
			return;
		}
		for (int i = 0 ; i < K; i++) {
			if (isSelected[i]) continue;
			result[count] = i;
			isSelected[i] = true;
			perm(count+1);
			isSelected[i] = false;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		operator = new ArrayList<Character>();
		st = new StringTokenizer(br.readLine());
		for( int i = 0 ; i < 4; i++) {
			int opnum = Integer.parseInt(st.nextToken());
			char op = ' '; //초기화 
			switch(i) {
			case 0: op = '+'; break;
			case 1: op = '-'; break;
			case 2: op = '*'; break;
			case 3: op = '/'; break;
			}
			for (int j = 0 ; j < opnum; j++) {
				operator.add(op);
			}	
		}
		K = operator.size(); //모든 연산자수의 합
		isSelected = new boolean[K];
		result = new int[K];
		perm(0);
		System.out.println(max);
		System.out.println(min);
		br.close();
	}
}
