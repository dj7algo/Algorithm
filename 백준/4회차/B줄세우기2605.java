package a0213;

import java.util.*;

//Arraylist에서 중간에 값넣기 이용
public class B2605 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		ArrayList<Integer> move = new ArrayList<>();
		move.add(0);
		
		for(int i=1; i<=n; i++) {		//기존 순서 입력 
			arr[i] = i;
			move.add(i);
		}

		for(int i=1; i<=n; i++) {
			int movelen = sc.nextInt();	//이동할 거리
			int nownum = arr[i];
			move.remove(i);
			move.add(i-movelen, nownum);
		}
		
		for(int i=1; i<=n; i++) {
			System.out.print(move.get(i)+" ");
		}
	}
}
