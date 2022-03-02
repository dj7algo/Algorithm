package week8;
import java.util.*;
import java.io.*;
public class Main_bj_1331_나이트투어 {
	
	static boolean validCheck(int curX, int curY, int nextX, int nextY) {
		//nextX의 범위안에 curX가 있어야겠지?
		int diffW = Math.abs(curX-nextX);
		int diffH = Math.abs(curY-nextY);
		if ( (diffW == 1 && diffH == 2) || (diffW ==2 && diffH == 1)) {
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] arr = new boolean[6][6];
		String first = br.readLine();
		int curY = first.charAt(0) - 'A';
		int curX = 5 - ((first.charAt(1) - '0')-1);
		
		int firstX = curX;
		int firstY = curY;
		
		arr[curX][curY] = true;
		boolean valid = true;
		for (int i = 0 ; i < 35; i++) {
			String line = br.readLine();
			int nextY = line.charAt(0)-'A';
			int nextX = 5 - ((line.charAt(1)-'0')-1);
			if (arr[nextX][nextY] == true) { // 조건 1. 중복이 되면 안된다.
				valid = false;
				break;
			}
			// 조건 2. 갈 수 있는곳을 가야한다. 이거 신경안쓰고 해보자
			if (!validCheck(curX,curY,nextX,nextY)) {
				valid = false;
				break;
			}
			curX = nextX;
			curY = nextY;
			arr[curX][curY] = true;
			if (i == 34 ) { // 조건 3. 마지막구간에서, 처음구간으로 가야함.
				//높이1차이 가로길이 2차이 or 높이2차이 가로길이 1차이
				if (!validCheck(curX,curY,firstX,firstY)) {
					valid = false;
					break;
				}
			}
			
		}
		System.out.println(valid ? "Valid" : "Invalid");

		
		br.close();
	}
}
