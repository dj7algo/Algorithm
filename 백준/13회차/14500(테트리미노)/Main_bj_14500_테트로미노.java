package week13;
import java.util.*;
import java.io.*;
public class Main_bj_14500_테트로미노 {
	static int max = 0;
	static int[][] arr;
	static int N;
	static int M;
	//shape1
	static void shape1(int x, int y) {
		//1. 가로줄
		if (y <= M-4) {
			int sum = 0;
			for (int i = 0 ; i < 4; i++) {
				sum += arr[x][y+i];
			}
			max = Math.max(max, sum);
		}
		//2. 세로줄
		if ( x <= N-4) {
			int sum = 0;
			for (int i = 0 ; i < 4; i++) {
				sum += arr[x+i][y];
			}
			max = Math.max(max, sum);
		}
	}
	//shape2
	static void shape2(int x, int y) {
		if ( x <= N-2 && y <= M-2) {
			int sum = 0;
			sum = arr[x][y] + arr[x][y+1] + arr[x+1][y] + arr[x+1][y+1];
			max = Math.max(max, sum);
		}
	}
	//shape3	
	static void shape3(int x, int y) {
		//3-1
		int[] di = {0,1,2}; 
		int[] dj = {1,1,1};
		int sum = arr[x][y];
		int count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
				
		//3-2
		di = new int[]{1,1,1}; 
		dj = new int[]{0,-1,-2};
		sum = arr[x][y];
		count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
		
		//3-3
		di = new int[]{1,2,2}; 
		dj = new int[]{0,0,1};
		sum = arr[x][y];
		count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
		
		//3-4
		di = new int[]{-1,-1,-1}; 
		dj = new int[]{0,1,2};
		sum = arr[x][y];
		count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
		
		//3-5
		di = new int[]{0,1,2}; 
		dj = new int[]{-1,-1,-1};
		sum = arr[x][y];
		count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
		
		//3-6
		di = new int[]{0,0,1}; 
		dj = new int[]{1,2,2};
		sum = arr[x][y];
		count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
		
		//3-7
		di = new int[]{1,2,2}; 
		dj = new int[]{0,0,-1};
		sum = arr[x][y];
		count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
		
		//3-8
		di = new int[]{1,1,1}; 
		dj = new int[]{0,1,2};
		sum = arr[x][y];
		count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
	}
	//shape4
	static void shape4(int x, int y) {
		//4-1
		int[] di = {1,1,2}; 
		int[] dj = {0,1,1};
		int sum = arr[x][y];
		int count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
		
		//4-2
		di = new int[]{1,1,2}; 
		dj = new int[]{0,-1,-1};
		sum = arr[x][y];
		count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
		//4-3
		di = new int[]{0,1,1}; 
		dj = new int[]{1,1,2};
		sum = arr[x][y];
		count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
		//4-4
		di = new int[]{0,1,1}; 
		dj = new int[]{-1,-1,-2};
		sum = arr[x][y];
		count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
	}
	//shape5
	static void shape5(int x, int y) {
		
		//5-1
		int[] di = {0,-1,0}; 
		int[] dj = {-1,0,1};
		int sum = arr[x][y];
		int count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
		
		//5-2
		di = new int[]{-1,1,0}; 
		dj = new int[]{0,0,1};
		sum = arr[x][y];
		count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
		
		//5-3
		di = new int[]{0,-1,1}; 
		dj = new int[]{-1,0,0};
		sum = arr[x][y];
		count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
		
		//5-4
		di = new int[]{0,1,0}; 
		dj = new int[]{-1,0,1};
		sum = arr[x][y];
		count = 0;
		for (int a = 0; a<3; a++) {
			int ni = x + di[a];
			int nj = y + dj[a];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				sum += arr[ni][nj];
				count++;
			}
		}
		if (count == 3) max = Math.max(sum, max); //3개 다 돌았을때만 max체크
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i =  0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0 ; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0 ; i < N; i++) {
			for (int j = 0 ; j < M; j++) {
				shape1(i,j);
				shape2(i,j);
				shape3(i,j);
				shape4(i,j);
				shape5(i,j);
			}
		}
		System.out.println(max);
		
		
		br.close();
	}
}
