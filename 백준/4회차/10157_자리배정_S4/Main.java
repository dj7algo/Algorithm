import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Main {
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String [] input = br.readLine().split(" ");
    	int x = Integer.parseInt(input[0]);	//7
    	int y = Integer.parseInt(input[1]); //6
    	int k = Integer.parseInt(br.readLine());
    	Node a = new Node(1,1);	// 사각형 왼쪽 하단
    	Node b = new Node(x,y);	// 사각형 우측 상단
    	
    	int start_idx = 1;	// 배열의 첫번째칸엔 1이 들어감
    	
    	int r = y;
    	int c = x;
    	
    	while(r>=1 && c>=1) {
    		
    		int end_idx = r*2 + c*2 -4 + start_idx-1;
    		// 배열 한바퀴에는 start_idx 부터 end_idx 값이 들어있다.
    		
    		if(start_idx <=k && k<= end_idx) {
    			
    			int num = start_idx;	// 여기서부터 값을 증가시키며 돌려볼거다.
    			int row = a.y;
    			int col = a.x;
    			
    			// 위쪽으로 배열가기
    			while(row <= b.y) {
    				if(num == k) {
        				System.out.println(col+" "+row);
        				return ;
        			}
    				// 아니면 위로 한칸씩 가기
    				row++;
    				num++;
    			}
    			row--;
    			num--;
    			// 왼쪽으로 가기
    			while(col <=b.x) {
    				if(num == k) {
        				System.out.println(col+" "+row);
        				return ;
        			}
    				col++;
    				num++;
    			}
    			col--;
    			num--;
    			
    			// 아럐쪽으로 가기
    			
    			while(row  >= a.y) {
    				if(num == k) {
        				System.out.println(col+" "+row);
        				return ;
        			}
    				row--;
    				num++;
    			}
    			row++;
    			num--;
    			
    			// 왼쪽으로 가기
    			
    			while(col >= a.x) {
    				if(num == k) {
        				System.out.println(col+" "+row);
        				return ;
        			}
    				col--;
    				num++;
    			}
    			
    			break;
    		}
    		
    		a.x++;
    		a.y++;
    		b.x--;
    		b.y--;
    		r-=2;
    		c-=2;
    		// 다음 배열 한바퀴에 들어가야하니 +1 추가
    		start_idx = end_idx+1;
    	}
    	
    	System.out.println(0);
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
