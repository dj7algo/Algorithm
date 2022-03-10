import java.util.*;
import java.io.*;
public class Main_bj_3967_매직스타 {
	static boolean[] used = new boolean[13];
	static boolean find = false;
	static boolean calcMagic(int[] arr) {
		//짝1 [ 0,2,5,7 ] 짝2 [ 7,8,9,10 ] 짝3 [ 10,6,3,0] 짝4 [ 1,5,8,11] 짝5 [ 11,9,6,4 ] 짝6 [ 4,3,2,1 ] 
		int sum1 = arr[0] + arr[2] + arr[5] + arr[7];
		int sum2 = arr[7] + arr[8] + arr[9] + arr[10];
		int sum3 = arr[10] + arr[6] + arr[3] + arr[0];
		int sum4 = arr[1] + arr[5] + arr[8] + arr[11];
		int sum5 = arr[11] + arr[9] + arr[6] + arr[4];
		int sum6 = arr[4] + arr[3] + arr[2] + arr[1];
		if (sum1 <= 26 && sum2 <= 26 && sum3 <= 26 && sum4 <=26 && sum5 <= 26&& sum6 <= 26) {
			return true;
		}else {
			return false;
		}
	}
	static void BFS(int[] arr , int count) {
		if (count == 12) {
			System.out.println("...." + (char)( (arr[0]-1) + 'A') + "....");
			System.out.println("." + (char)( (arr[1]-1) + 'A') + "." + (char)( (arr[2]-1) + 'A') + "." + (char)( (arr[3]-1) + 'A') + "." + (char)( (arr[4]-1) + 'A') + ".");
			System.out.println(".." + (char)( (arr[5]-1) + 'A')  + "..." + (char)( (arr[6]-1) + 'A') + "..");
			System.out.println("." + (char)( (arr[7]-1) + 'A') + "." + (char)( (arr[8]-1) + 'A') + "." + (char)( (arr[9]-1) + 'A') + "." + (char)( (arr[10]-1) + 'A') + ".");
			System.out.println("...." + (char)( (arr[11]-1) + 'A') + "....");
			find = true;
			return;
		}
		//1. arr중에서 아직 비어있는 칸을 찾는다.
		int index = 0;
		for (int i = 0 ; i < 12; i++) {
			if (arr[i] == 0) {
				index = i;
				break;
			}
		}
		//2. 빈칸에 사용안하고있는 값을 넣고, 짝6개를 계산해서 통과하면, 사용중인값에 넣고, 다음으로 너머간다. 근데 안나오면 다시 돌아와서 다음값으로 해야함.
		for (int i = 1 ; i < 13; i++) {
			if (!used[i]) {
				int[] newarr = Arrays.copyOf(arr, 12);
				newarr[index] = i;
				if (calcMagic(newarr) && ! find) {
					used[i] = true;
					BFS(newarr, count+1);
					used[i] = false;
				}
				
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[12];
//		boolean[] used = new boolean[13];
		int index = 0;
		int count = 0;
		used[0] = true; //0번은 무조건 사용중
		//배열넣기
		for (int i = 0 ; i < 5 ; i++) {
			String line = br.readLine();
			for (int j = 0 ; j < 9; j++) {
				char a = line.charAt(j);
				if (a == 'x') {
					arr[index++] = 0;
				}else if ( a != '.') {
					arr[index++] = a-'A'+1;
					count++;
					used[a-'A'+1] = true;
				}
			}
		}
		BFS(arr,count);
		//짝1 [ 0,2,5,7 ] 짝2 [ 7,8,9,10 ] 짝3 [ 10,6,3,0] 짝4 [ 1,5,8,11] 짝5 [ 11,9,6,4 ] 짝6 [ 4,3,2,1 ] 
		
		
		
		br.close();
	}
}
