import java.io.*;
import java.util.*;

public class Main {
	static Queue<Node> q = new LinkedList<>();
	static ArrayList<Node> tmp = new ArrayList<>();
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	String [] t = br.readLine().split(" ");
    	int c = Integer.parseInt(t[0]);
    	int r = Integer.parseInt(t[1]);
    	
    	q.add(new Node(r,0,0,c));
    	// 사각형의 왼쪽아래  = x,y
    	// 사각형 오른쪽의 위 = p,q
    	
    	int n = Integer.parseInt(br.readLine());	// 잘라야하는 개수
    	if(n==0) {
    		System.out.println(r*c);
    		return;
    	}
    	for(int i=0; i<n; i++) {
    		t = br.readLine().split(" ");
    		
    		int idx = Integer.parseInt(t[0]);	// 가로 = 0 , 세로 = 1
    		int pos = Integer.parseInt(t[1]);	// 자르는 위치
    		
    		int size = q.size();
    		
    		if(idx ==0) {	// 가로 자를때
    			
    			while(size -->0) {
    				Node a = q.poll();
    				
    				if(a.p <pos && pos<a.x) {
    					q.add(new Node(pos,a.y,a.p,a.q));
    					q.add(new Node(a.x,a.y,pos,a.q));
    				}
    				else q.add(a);
    				
    			}
    			
    		}
    		
    		else {	// 세로 자를때
    			while(size -- >0) {
    				Node a = q.poll();
    				
    				if(a.y < pos && pos < a.q) {
    					q.add(new Node(a.x,a.y,a.p,pos));
    					q.add(new Node(a.x,pos,a.p,a.q));
    				}
    				else q.add(a);
    			}
    		}
    	}
    	
    	int sum = 0;
    	while(!q.isEmpty()) {
    		Node a = q.poll();
    		int tmp = (Math.abs(a.x-a.p)) * (Math.abs(a.y-a.q));
    		sum = Math.max(sum, tmp);
    	}
    	if(sum ==0) {
    		System.out.println(r*c);
    	}
    	else System.out.println(sum);
   
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
