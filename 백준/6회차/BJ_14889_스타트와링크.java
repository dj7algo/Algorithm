import java.util.*;
import java.io.*;
/*
 * 임시로 생각나는대로 짠 코드라 리펙토링 필요
 * 비효율+++++
 * */
public class Main {
	static int N;
	static int[][] food;
	static int[] A; //4개 있어야함
	static int[] B;
	static boolean[] isSelected; //N개 있어야함
	static int sum;
	static int min;
	static int[] result;
	
//	static void Perm(int[] arr, int count) {
//		if (count == 2) {
//			sum += food[result[0]][result[1]];
//			return;
//		}
//		for (int i = 0 ; i < N/2; i++) {
//			if(isSelected[i]) continue;
//			result[count] = arr[i];
//			isSelected[i] = true;
//			Perm(arr, count+1);
//			isSelected[i] = false;
//		}
//	}
	static void Combination(int count, int start) {
		if (count == N/2) {
			
			//A를 이용해서 B를 만든다.
			boolean[] all = new boolean[N];
			for (int num : A) {
				all[num] = true;
			}
			//B만들기
			int size = 0;
			for (int i = 0 ; i < N ;i++) {
				if (!all[i]) {
					B[size++] = i;
				}
			}
//			sum = 0;//초기화
//			Perm(A,0); //Asum구하기
//			int Asum = sum;
//			sum = 0;
//			Perm(B,0);//Bsum구하기
//			int Bsum = sum; 
//			int diff = Math.abs(Asum-Bsum); //두값의 차이
//			min = Math.min(min, diff);
			int sumA = 0;
			int sumB = 0;
			//계산기
			for (int i = 0 ; i < N/2; i++) {
				for (int j = i ; j < N/2; j++) {
					sumA += food[A[i]][A[j]];
					sumA += food[A[j]][A[i]];
					sumB += food[B[i]][B[j]];
					sumB += food[B[j]][B[i]];
				}
			}
			int diff = Math.abs(sumA-sumB);
			min = Math.min(diff, min);
			
			return;
		}
		for (int i = start; i < N; i++) {
			if (count == 0 && i != 0) {
				break;
			}
			A[count] = i;
			Combination(count+1,i+1);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		min = Integer.MAX_VALUE;
		N = Integer.parseInt(br.readLine());
		food = new int[N][N];
		A = new int[N/2];
		B = new int[N/2];
		result = new int[2];
		isSelected = new boolean[N/2];
		//1. 배열넣기
		for (int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < N; j++) {
				food[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Combination(0,0); 
		sb.append(min).append("\n");
		System.out.print(sb.toString());
		
		br.close();
	}
}
