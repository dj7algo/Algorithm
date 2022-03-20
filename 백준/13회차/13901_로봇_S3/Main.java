import java.io.*;
import java.util.*;
public class Main {
	static int r,c,k;
	static int map[][];
	static int dx[] = {0,-1,1,0,0};
	static int dy [] = {0,0,0,-1,1};
	static boolean visited[][];
	static int robot_x =0;
	static int robot_y = 0;
	static int dir[] = new int[4];
	static int idx = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        map = new int[r][c];
        visited = new boolean[r][c];
        
        k = Integer.parseInt(br.readLine());
        
        for(int i=0; i<k; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	map[x][y] = -1;
        }
        
        
        st = new StringTokenizer(br.readLine());
        robot_x=  Integer.parseInt(st.nextToken());
        robot_y = Integer.parseInt(st.nextToken());
        map[robot_x][robot_y] = -1;
        
        
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
        	dir[i] = Integer.parseInt(st.nextToken());
        }
        
        
        int cnt = 0;
        while(true) {
        	if(cnt==4) {
        		System.out.println(robot_x+" "+robot_y);
        		System.exit(0);
        	}
        	// 로봇은 사용자가 지정한 방향을 일직선으로 움직인다
        	int nx = robot_x+dx[dir[idx]];
        	int ny = robot_y+dy[dir[idx]];
        	

        	
        	if(isRange(nx,ny) && map[nx][ny] != -1) {
        		robot_x = nx;
        		robot_y = ny;
        		map[nx][ny] = -1;

        		nx+=robot_x+dx[dir[idx]];
        		ny+=robot_y+dy[dir[idx]];
        		cnt = 0;
        		
        	}
        	
        	else {
        		idx++;
        		if(idx ==4) idx=0;
        		cnt++;
        	}
        	
        	
        	
        }
        
        
	}
	static boolean isRange(int x, int y) {
		if(x>= 0 && y>=0 && x<r && y<c) return true;
		return false;
	}
}