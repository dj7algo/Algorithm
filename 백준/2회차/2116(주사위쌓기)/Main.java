import java.io.*;
import java.util.*;

public class Main{
	static int N; 
	static int[][] dice = new int[N][6]; 
	static int max;
	static int result = 0;

	// 재귀함수로, 1층부터 차례대로 올라가면서 위아래면 제외하고 Max값 출력
	static void findmax(int floor, int bot) {
		if (floor == N) {
			return;
		}else {
			int nextbot = 0;
			for (int i = 0 ; i < 6; i++) {
				if (dice[floor][i] == bot) {
					Set<Integer> temp = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6)); // 여기서 위아래값을 제거한다음에 최대값을 찾을것임. 코드 더럽다
					switch(i) {
					case 0:
						nextbot = dice[floor][5];
						temp.remove(dice[floor][0]);
						temp.remove(dice[floor][5]);
						break;
					case 1:
						nextbot = dice[floor][3];
						temp.remove(dice[floor][1]);
						temp.remove(dice[floor][3]);
						break;
					case 2:
						nextbot = dice[floor][4];
						temp.remove(dice[floor][2]);
						temp.remove(dice[floor][4]);
						break;
					case 3:
						nextbot = dice[floor][1];
						temp.remove(dice[floor][3]);
						temp.remove(dice[floor][1]);
						break;
					case 4:
						nextbot = dice[floor][2];
						temp.remove(dice[floor][4]);
						temp.remove(dice[floor][2]);
						break;
					case 5:
						nextbot = dice[floor][0];
						temp.remove(dice[floor][5]);
						temp.remove(dice[floor][0]);
						break;
					}
					max += Collections.max(temp);
					break;
				}
				
			}
			findmax(floor+1, nextbot); // 다음층으로 올리면서 주사위 맨 아랫값 보냄.
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //주사위 개수
		dice = new int[N][6]; 
		/* 주사위 모양 
		   A
		 B C D E
		   F
		   인덱스로 따지면 짝꿍은 (0,5),(1,3),(2,4) 
		 */
		for(int i = 0 ;i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); //한줄씩 읽기
			for(int j = 0 ; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 1층 맨위가 1일때 2일때 ... 6일때 까지 전부찾아보기!
		for (int x = 1 ; x <= 6; x++) {
			max = 0;
			findmax(0,x);
			if (max > result) result = max;
		}
		System.out.println(result);
		
	}
}
