import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    	boolean visited[][] = new boolean[101][101];
    	for(int a=0; a<4; a++) {
    		String [] input = br.readLine().split(" ");
       	
    		int x = Integer.parseInt(input[0]);
    		int y = Integer.parseInt(input[1]);
    		int p = Integer.parseInt(input[2]);
    		int q = Integer.parseInt(input[3]);
    		for(int i=x; i<p; i++) {
    			for(int j=y; j<q; j++) {
    				visited[i][j] = true;
    			}
    		}
    	}
    	int ans = 0;
    	for(int i=0; i<=100; i++) {
    		for(int j=0; j<=100; j++) {
    			if(visited[i][j]) ans++;
    		}
    	}
    	System.out.println(ans);
    }
}
