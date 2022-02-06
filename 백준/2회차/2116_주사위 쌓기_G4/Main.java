package tomyself;


import java.io.*;
import java.util.*;
public class Main {
	static int dice[][];
	static int max = 0;
	static int n;
	static Node info [];
	public static void main(String[] args) throws Exception {
		
		/*
		 * A,B,C,D,E,F = 1,2,3,4,5,6
		 * 마주보는 면 (A,F) , (B,D), (C,E)
		 * 
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());	// 주사위 개수
		dice = new int[n+1][7];					// n개의 주사위 + 각 주사위의 각면을 저장
		info = new Node[n+1];					// n개의 주사위의 윗면, 아랫면 정보를 담을거
		for(int i=0; i<n; i++) {
			String [] input = br.readLine().split(" ");
			
			// 주사위 입력
			for(int j=0; j<6; j++) {
				dice[i+1][j+1] = Integer.parseInt(input[j]);
			}
		}
		
		// A주사위 6면 다 해보기
		// 여기는 A주사위의 윗면을 알아야
		for(int i=1; i<=6; i++) {
			int numA = dice[1][i];	// 1번 주사위의 6개의 숫자중 하나
			if(i==1 || i==6)		info[1] = new Node(1,6);
			else if(i==2 || i==4)	info[1] = new Node(2,4);
			else info[1] = new Node(3,5);
			

			
			
			dfs(numA,2);
		}
		System.out.println(max);
	}
	public static void dfs(int num,  int level) {
		
		if(level ==n+1) {
			max = Math.max(max, getSum());
			return ;
		}
		
		for(int i=1; i<=6; i++) {
			if(num == dice[level][i]) {
				// 숫자가 같은 다른 주사위의 윗면,아랫면 구하기
				if(i==1 || i==6) info[level] = new Node(1,6);
				else if(i==2 || i==4) info[level] = new Node(2,4);
				else info[level] = new Node(3,5);
				dfs(getTopNum(i,level),level+1);
			}
		}
	}
	public static int getTopNum(int down, int level) {
		
		if(down ==1) return dice[level][6];
		if(down ==2) return dice[level][4];
		if(down ==3) return dice[level][5];
		if(down ==4) return dice[level][2];
		if(down ==5) return dice[level][3];
		if(down ==6) return dice[level][1];
		return 10000;
	}
	public static int getSum() {
		
		int sum = 0;	// 각 주사위의 옆면의 최종 합을 담을 변수
		for(int i=1; i<=n; i++) {
			Node node = info[i];		// 각각의 주사위의 윗면과 아랫면의 정보를 갖고있는 객체
			int tmp = 0;	// 각 주사위의 옆면중 가장 큰 값을 담을 변수
			for(int j=1; j<=6; j++) {
				if(j==node.top || j== node.down) continue;	// 6개의 면 중 윗면,아랫면이면 스킵
				tmp = Math.max(tmp, dice[i][j]);
			}
			sum+=tmp;		// 각 주사위의 옆면중 가장 큰 면을 더해줌
		}
		return sum;
	}
 }
class Node{
	int top,down;

	public Node(int top, int down) {
		this.top = top;
		this.down = down;
	}
	
}