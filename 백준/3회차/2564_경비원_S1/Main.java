import java.io.*;
import java.util.*;
public class Main {
	
	static ArrayList<Node>list = new ArrayList<>();
	static Node node;
	static int sum = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String [] t = br.readLine().split(" ");
		
		int c = Integer.parseInt(t[0]);
		int r = Integer.parseInt(t[1]);
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			t = br.readLine().split(" ");
			int dir = Integer.parseInt(t[0]);
			int dist = Integer.parseInt(t[1]);
			
			list.add(new Node(dir,dist));
		}
		
		t = br.readLine().split(" ");	// 동근이의 위치
		node = new Node(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
		
		// 동근이가 북쪽에 있는경우
		if(node.dir == 1) {
			
			for(int i=0; i<n; i++) {
				Node shop = list.get(i);
				
				// 북
				if(shop.dir==1) sum+=Math.abs(node.dist-shop.dist);
				
				// 남
				if(shop.dir==2) {
					// 북->동->남 순서로 가는 경우
					int tmp1 = ((c-node.dist) + r + (c-shop.dist));
					// 북->서->남 순서로 가는 경우
					int tmp2 = node.dist + r + shop.dist;
					
					sum+=(Math.min(tmp1, tmp2));
				}
				//서쪽
				if(shop.dir==3) sum+=(shop.dist+ node.dist);
				
				// 동쪽
				if(shop.dir==4) {
					sum+= (c-node.dist) + shop.dist;
				}
			}
		}
		// 동근이가 남쪽에 있는경우
		if(node.dir==2) {
			
			for(int i=0; i<n; i++) {
				Node shop = list.get(i);
				
				// 북
				if(shop.dir ==1) {
					// 남->서->북
					int tmp1 = node.dist+r+shop.dist;
					// 남->동->북
					int tmp2 = ( (c-node.dist)+r+(c-shop.dist));
					sum+=Math.min(tmp1, tmp2);
				}
				// 남
				if(shop.dir==2) sum+=Math.abs(node.dist-shop.dist);
				
				//서
				if(shop.dir==3) {
					sum+= (node.dist + (r-shop.dist));
				}
				// 동
				if(shop.dir==4) {
					sum+= ( (c-node.dist) + (r-shop.dist));
				}
				
			}
		}
		
		// 동근이가 서쪽방향에 있는경우
		if(node.dir==3) {
			
			for(int i=0; i<n; i++) {
				Node shop = list.get(i);
				
				// 북쪽
				if(shop.dir==1) {
					sum+=node.dist+shop.dist;
				}
				// 남쪽
				if(shop.dir==2) {
					sum+=( (r-node.dist) + shop.dist);
				}
				// 서쪽
				if(shop.dir==3) sum+=(Math.abs(shop.dist-node.dist));
				
				// 동쪽
				if(shop.dir==4) {
					
					// 서 -> 남 -> 동
					int tmp1 = ((r-node.dist) +c + (r-shop.dist));
					// 서->북->동
					int tmp2 = (node.dist+c+shop.dist);
					sum+=Math.min(tmp1, tmp2);
				}
			}
		}
		// 동근이가 동쪽에 있는경우
		if(node.dist==4) {
			for(int i=0; i<n; i++) {
				Node shop = list.get(i);
				
				// 북쪽
				if(shop.dir==1) {
					sum+=node.dist + (c-shop.dist);
				}
				// 남쪽
				if(shop.dir==2) {
					sum+= ((r-node.dist) + (c-shop.dist));
				}
				// 서쪽
				if(shop.dir==3) {
					// 동->북->서
					int tmp1 = shop.dist+c+node.dist;
					// 동->남->서
					int tmp2 = (r-node.dist) + c + (r-shop.dist);
					sum+=Math.min(tmp1, tmp2);
				}
				if(shop.dir==4) {
					sum+=Math.abs(node.dist-shop.dist);
				}
			}
		}
		System.out.println(sum);
		
	}
 }
class Node{
	int dir,dist;

	public Node(int dir, int dist) {
		super();
		this.dir = dir;
		this.dist = dist;
	}
	
}