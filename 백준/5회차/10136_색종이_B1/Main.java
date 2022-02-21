import java.io.*;
import java.util.*;
public class Main {

	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	int map [][] = new int[1002][1002];
    	
    	
    	for(int i=0; i<n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
        	
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		int w = Integer.parseInt(st.nextToken());
    		int h = Integer.parseInt(st.nextToken());
    		
    		
    		for(int j=x; j<x+w; j++) {
    			for(int k=y; k<y+h; k++) {
    				map[j][k] = i+1;
    			}
    		}
    	}
    	
    	
    	for(int i=1; i<=n; i++) {
    		int cnt = 0;
    		for(int j=0; j<1002; j++) {
    			for(int k=0; k<1002; k++) {
    				if(map[j][k]==i) cnt++;
    			}
    		}
    		System.out.println(cnt);
    	}
    	
	}
}
