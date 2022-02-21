import java.io.*;
import java.util.*;
public class Main {


	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	
    	int n = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	// 별 동그라미 네모 세모 
    	// 4      3     2     1
    	for(int i=0; i<n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
        	Node A = new Node();
        	Node B = new Node();
        	st.nextToken();
    		while(st.hasMoreTokens()) {
    		
    			int num = Integer.parseInt(st.nextToken());
    			
    			if(num ==4) A.star++;
    			if(num ==3) A.circle++;
    			if(num ==2) A.rectangle++;
    			if(num ==1) A.triangle++;
    		}
    		st = new StringTokenizer(br.readLine());
    		st.nextToken();
    		while(st.hasMoreTokens()) {
    
    			int num = Integer.parseInt(st.nextToken());
    			if(num ==4) B.star++;
    			if(num ==3) B.circle++;
    			if(num ==2) B.rectangle++;
    			if(num ==1) B.triangle++;
    		}
    		
    		if(A.star > B.star) {
    			sb.append("A"+"\n");
    		}
    		else if(A.star < B.star) {
    			sb.append("B"+"\n");
    		}
    		else {
    			if(A.circle > B.circle) {
    				sb.append("A"+"\n");
    			}
    			else if(A.circle < B.circle) {
    				sb.append("B"+"\n");
    			}
    			else {
    				if(A.rectangle > B.rectangle) {
    					sb.append("A"+"\n");
    				}
    				else if(A.rectangle<B.rectangle) {
    					sb.append("B"+"\n");
    				}
    				else {
    					if(A.triangle > B.triangle) {
    						sb.append("A"+"\n");
    					}
    					else if(A.triangle < B.triangle) {
    						sb.append("B"+"\n");
    					}
    					else {
    						sb.append("D"+"\n");
    					}
    				}
    			}
    		}
    		
    	}
    	System.out.println(sb);
	}
}
class Node{
	int star,circle,triangle,rectangle;

	public Node() {};
}