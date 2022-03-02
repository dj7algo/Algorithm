import java.util.*;
import java.io.*;

class Main{
	static int dx [] = {-1,1,-2,2,-2,2,-1,1};
	static int dy [] = {-2,-2,-1,-1,1,1,2,2};
	static boolean visited[][];
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		visited = new boolean[6][6];
		ArrayList<Node>list = new ArrayList<>();
		for(int i=0; i<36; i++) {
			String input = br.readLine();
			
			int num1= input.charAt(0)-'A';
			int num2 = input.charAt(1)-'1';
			list.add(new Node(num1,num2));
			visited[num1][num2] = true;
		}
		
		// 1. 모든 칸을 정확히 한 번씩 방문한다
		int cnt = 0;
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(visited[i][j]) cnt++;
			}
		}
		if(cnt!=36) {
			System.out.println("Invalid");
			System.exit(0);
		}
		
		
		int x = list.get(0).x;
		int y = list.get(0).y;
		for(int i=1; i<list.size(); i++) {
			
			int tmp_x = list.get(i).x;
			int tmp_y = list.get(i).y;
			boolean flag = false;
			
			for(int j=0; j<8; j++) {
				int nx = x+dx[j];
				int ny = y+dy[j];
		
				if(nx == tmp_x && ny == tmp_y) {
					x = tmp_x;
					y = tmp_y;
					flag = true;
					break;
				}	
				
				
			}
			if(!flag) {
				System.out.println("Invalid");
				System.exit(0);
			}
		}
		
		// 마지막에서 처음으로 돌아갈수 있는지 체크
		
		for(int i=0; i<8; i++) {
			int nx = list.get(35).x +dx[i];
			int ny = list.get(35).y+dy[i];
			
			if(nx==list.get(0).x && ny == list.get(0).y) {
				System.out.println("Valid");
				System.exit(0);
			}
		}
		
		System.out.println("Invalid");
	}
}
class Node{
	int x,y;

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}