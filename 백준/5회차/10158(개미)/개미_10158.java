import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = (Integer.parseInt(st.nextToken()) );
		int height = (Integer.parseInt(st.nextToken()) );
		
		st = new StringTokenizer(br.readLine());
		int curX = Integer.parseInt(st.nextToken()); 
		int curY =  Integer.parseInt(st.nextToken()); 
		int T = Integer.parseInt(br.readLine());
		int interval = 0; // 주기
		if (width == height) {//둘이같음
			interval = width*2;
		}else if ( (width %2 == 0) && (height %2 == 0) ) {//둘다짝수
			interval = width*height;
		}else { //홀수 하나라도 끼어있음
			interval = width*height*2;
		}
		T = T % interval;
		int[] dx = {-1, 1,1,-1}; //왼쪽위 , 오른쪽위, 오른쪽아래, 왼쪽아래
		int[] dy = {1, 1,-1,-1}; //왼쪽위 , 오른쪽위, 오른쪽아래, 왼쪽아래
		int dir = 1; 
		int num = 0;
		while(num <T) {
			int mov = 0;
			switch (dir) {
			case 0: //왼쪽 위
				mov = Math.min(curX, height-curY);
				break;
			case 1: // 오른쪽 위
				mov = Math.min(width-curX, height-curY);
				break;
			case 2: // 오른쪽 아래
				mov = Math.min(width-curX, curY);
				break;
			case 3: // 왼쪽 아래
				mov = Math.min(curX, curY);
				break;
			}
			int remain = T-num; //남은 이동거리
			if (remain < mov) { //만약 이동하는 크기보다, 적게 남았다면, 남은만큼만 이동
				mov = remain;
				curX = curX + mov*dx[dir];
				curY = curY + mov*dy[dir];
				break;
			}
			curX = curX + (mov*dx[dir]);
			curY = curY + (mov*dy[dir]);
			//넘기기전에 방향전환
			switch(dir) { //왼쪽위 , 오른쪽위, 오른쪽아래, 왼쪽아래
			case 0: //
				if (curX == 0 && curY == height) dir = 2; //오아
				else if (curX == 0) dir = 1;//오위
				else if (curY == height) dir = 3;//왼아
				break;
			case 1:
				if (curX == width && curY == height) dir = 3;//왼아
				else if (curX == width) dir = 0;//왼위
				else if (curY == height) dir = 2; //오아
				break;
			case 2:
				if (curX == width && curY == 0) dir = 0; //왼위
				else if (curX == width) dir = 3; //왼아
				else if (curY == 0) dir = 1; //오위
				break;
			case 3:
				if (curX == 0 && curY == 0) dir = 1; //오위
				else if (curX == 0) dir = 2; //오아
				else if (curY == 0) dir = 0; //왼위
				break;
			}
			num += mov; //아직 남았으면, mov만큼 이동
		}
		System.out.println(curX + " " + curY);

		
	}
}
