import java.io.*;
import java.util.*;
public class Main {

	static char map[][];
	static int n =5;
	static int m = 9;
	static char arr[];
	static boolean visited[];
	static ArrayList<Node>list = new ArrayList<>();	// 채워야 될 칸의 정보
    public static void main(String[] args)  throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        map = new char[n][m];
        visited = new boolean[('L'-'A') +1];
        for(int i=0; i<n; i++) {
        	String str = br.readLine();
        	for(int j=0; j<m; j++) {
        		char ch = str.charAt(j);
        		
        		map[i][j] = ch;
        		if(map[i][j]=='x') list.add(new Node(i,j));
        		else if(map[i][j]!='.'){
        			visited[ch-'A'] = true;
        		}
        	}
        }
        arr = new char[list.size()];	
        dfs(0);

    }
    public static void dfs(int level) {
    	if(level == list.size()) {
    		char tmp_map [][] = copy();
    		//System.out.println("?");
    		
    		if(isPossible(tmp_map)) {
    			for(int i=0; i<n; i++) {
    				for(int j=0; j<m; j++) {
    					System.out.print(tmp_map[i][j]+"");
    				}
    				System.out.println();
    			}
    			System.exit(0);
    		}
    		return ;
    	}
    	
    	for(int j=0; j<='L'-'A'; j++) {
			if(visited[j]) continue;	// 이미 사용한 알파벳
			
			visited[j] = true;
			
			int tmp_alpha = j+'A';
			arr[level] = (char)tmp_alpha;
			dfs(level+1);
			visited[j] = false;
		}
    	
    }
    public static boolean isPossible(char map[][]) {
    	
    	int sum = 0;
    	// 1행에서 왼쪽 대각선 체크
    	sum = map[0][4]-'A' + map[1][3] -'A' + map[2][2] -'A' + map[3][1]-'A';
    	
    	if(sum!=22) return false;
    	
    	
    	// 1행에서 오른쪽 대각선 체크
    	
    	sum = map[0][4]-'A' + map[1][5]-'A' + map[2][6]-'A' + map[3][7]-'A';
    	if(sum!=22) return false;
    	
    	// 2행에서 일직선 체크
    	sum = map[1][1]-'A' + map[1][3]-'A'+map[1][5]-'A'+map[1][7]-'A';
    	if(sum!=22) return false;
    	
    	// 2행 대각선 체크
    	sum = 0;
    	sum = map[1][1]-'A' + map[2][2] -'A' + map[3][3]-'A' + map[4][4]-'A';
    	if(sum!=22) return false;
    	
    	// 2행 오른쪽 대각선 체크
    	sum = map[1][7]-'A' + map[2][6]-'A' + map[3][5]-'A' + map[4][4]-'A';
    
    	// 4행 일직선 체크
    	sum = map[3][1] -'A' + map[3][3]-'A' + map[3][5]-'A' + map[3][7]-'A';
    	if(sum!=22) return false;
    	
    	return true;
    	
    }
    public static char[][] copy(){
		char [][] tmp_map = new char[n][m];
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				tmp_map[i][j] = map[i][j];
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			tmp_map[list.get(i).x][list.get(i).y] = arr[i];
		}
		return tmp_map;
    }
    public static void print() {
    	System.out.println("=======================");
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		System.out.print(map[i][j]+" ");
        	}
        	System.out.println();
        }
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
