import java.io.*;
import java.util.*;
public class Main {
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		boolean visited[][] = new boolean[101][101];
		
		for(int i=0; i<n; i++) {
			String [] input = br.readLine().split(" ");
			int x=  Integer.parseInt(input[0]);
			int y =Integer.parseInt(input[1]);
			
			for(int a=x; a<x+10;a++) {
				for(int j=y; j<y+10; j++) {
					visited[a][j] = true;
				}
			}
		}
		int ans = 0;
		for(int i=1 ;i<=100; i++) {
			for(int j=1; j<=100; j++) {
				if(visited[i][j]) {
					ans++;
				}
			}
		}
		System.out.println(ans);
		
	}
 }
