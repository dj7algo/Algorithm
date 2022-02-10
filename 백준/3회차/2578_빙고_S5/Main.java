import java.io.*;
import java.util.*;
public class Main {
	static int map[][];
	static int dx [] = {0,1,1,1};
	static int dy [] = {1,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		map = new int [5][5];
		
		for(int i=0; i<5; i++) {
			String [] input = br.readLine().split(" ");
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		
		int cnt = 0;
		for(int i=1; i<=5; i++) {
			String [] input = br.readLine().split(" ");
			
			for(int j=0; j<5; j++) {
				cnt++;
				int num = Integer.parseInt(input[j]);
				delete(num);
				if(check()) {
					System.out.println(cnt);
					System.exit(0);
				}
			}
			
		}
	}
	public static boolean check() {
		int bingo = 0;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				for(int k=0; k<4; k++) {
					int cnt = 0;
					
					int nx = i-dx[k];
					int ny = j-dy[k];
					for(int l=0; l<5; l++) {
						 nx+=dx[k];
						 ny +=dy[k];
						 
						if(!isRange(nx,ny)) break;

						if(map[nx][ny]==-1) cnt++;
					}

					if(cnt==5) bingo++;
				}
			}
		}
		if(bingo>=3) return true;
		return false;
	}
	public static boolean isRange(int x,int y) {
		if(x>=0 && y>=0 && x<5 && y<5) return true;
		return false;
	}
	public static void delete(int num) {
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(map[i][j]==num) {
					map[i][j] = -1;
					return ;
				}
			}
		}
		
	}
 }
