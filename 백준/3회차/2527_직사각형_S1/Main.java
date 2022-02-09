import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node a = new Node(0,0,0,0);
		Node b = new Node(0,0,0,0);
		for(int i=0; i<4; i++) {
			String [] input = br.readLine().split(" ");
			
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			int p = Integer.parseInt(input[2]);
			int q = Integer.parseInt(input[3]);
			
			a = new Node(x,y,p,q);
			
			x = Integer.parseInt(input[4]);
			y = Integer.parseInt(input[5]);
			p = Integer.parseInt(input[6]);
			q = Integer.parseInt(input[7]);
			
			b = new Node(x,y,p,q);
			
			
			// (c) 겹치는게 있을경우
			
			if( (a.x == b.p && a.y == b.q) || (a.p==b.x && a.q == b.y) || (a.x==b.p && a.q ==b.y) || (a.p == b.x && a.y == b.q)) {
				System.out.println("c");
			}
			
			// (d) 공통 부분이 없음
			else if(a.q < b.y || a.y > b.q || a.x > b.p || a.p < b.x) {
				System.out.println("d");
			}
			// (b) 겹치는 선분이 있는 경우
			else if( (a.q == b.y) || (a.x == b.p)  || (a.y == b.q)  || (a.p == b.x)) {
				System.out.println("b");
			}
			
			
			else System.out.println("a");
		}

		
	}
 }
class Node{
	int x,y,p,q;

	public Node(int x, int y, int p, int q) {
		super();
		this.x = x;
		this.y = y;
		this.p = p;
		this.q = q;
	}

	
	
}