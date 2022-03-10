import java.util.*;
import java.io.*;
public class Main_bj_3190_뱀 {
	
	static int dirchange(int cur, int second, List<int[]> change ) {
		if (change.isEmpty()) {
			return cur;
		} //방향전환정보가 없으면, 그냥 그방향 그대로 간다.
		int[] direction = change.get(0);//change정보중에, 맨앞에 정보만 유의미함.
		if (second == direction[0]) {
			//방향전환초를 만나면 전환한다.
			int after = cur + direction[1]; // 저장해놓은 정보대로 방향전환 90도 or -90도
			if (after == -1) after = 3; // 인덱싱
			if (after == 4) after = 0; // 인덱싱
			change.remove(0); //마지막에 방향전환에 사용한 방향전환정보는 제거한다.
			return after;
		}else {
			return cur;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 보드의 크기
		int[][] board = new int[N][N];
		int K = Integer.parseInt(br.readLine()); // 사과의 개수
		for (int i = 0 ; i < K ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			board[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2; //사과는 2로 표시, 배열인덱스 맞추려고 -1함
		}
		int L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수
		List<int[]> change = new LinkedList<int[]>(); //뱀의 방향 변환 리스트
		for (int i = 0 ; i < L ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int second = Integer.parseInt(st.nextToken());
			int dir = st.nextToken().equals("D") ? 1 : -1; // D면 오른쪽, L이면 왼쪽  
			change.add(new int[] { second , dir });
		}
		
		int[] di = {0, -1, 0, 1};// 좌 상 우 하
		int[] dj = {-1, 0, 1, 0};// 좌 상 우 하
		int second = 0;
		int curX = 0;
		int curY = 0;
		int dir = 2; //최초 방향은 오른쪽
		List<int[]> snake = new LinkedList<int[]>();
		snake.add(new int[] {curX, curY}); //머리겸 꼬리
		//사과는 2, 뱀은 1, 빈곳은 0으로 표시
		while ( true ) {
			second++;
			int nextX = curX+di[dir];
			int nextY = curY+dj[dir];
			if ( nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && board[nextX][nextY] != 1) {
				//뱀 머리 추가
				snake.add(0, new int[] {nextX, nextY});
				if (board[nextX][nextY] == 2) {
					
				}else {
					//사과 없으면, 꼬리 잘라내고, 꼬리자리 비움.
					int[] tail = snake.remove(snake.size()-1);
					board[tail[0]][tail[1]] = 0;
				}
				board[nextX][nextY] = 1;
				//현재위치 바꾸기
				curX = nextX; 
				curY = nextY; 
				dir = dirchange(dir, second,change);
				
				//
			}else { //벽을만나거나, 자기몸통과 만난경우 게임OVER
				System.out.println(second);
				break;
			}
			
		}
		
		
		br.close();
	}
}
