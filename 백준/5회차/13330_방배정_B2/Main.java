import java.io.*;
import java.util.*;
public class Main {


	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int t = Integer.parseInt(st.nextToken());
    	
    	int arr[][] = new int[n][2];
    	
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int s= Integer.parseInt(st.nextToken());
    		int y =Integer.parseInt(st.nextToken());
    		
    		arr[i][0] = s;
    		arr[i][1] = y;
    	}
    	
    	Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
    	int grade = 1;
    	int boy =0;
    	int girl = 0;
    	int cnt = 0;
    	for(int i=0; i<n; i++) {
    		int s = arr[i][0];
    		int y = arr[i][1];
    		
    		if(grade!=y) {
    			grade = y;
    			
    			if(boy%t==0) {
    				cnt+=boy/t;
    			}
    			else {
    				cnt+=boy/t + 1;
    			}
    			
    			if(girl%t==0) {
    				cnt+=girl/t;
    			}
    			else {
    				cnt+=girl/t + 1;
    			}
    			boy=0;
    			girl =0;
    		}
    		
    		if(s==0) girl++;
    		else boy++;
    	}
    	if(boy%t==0) {
			cnt+=boy/t;
		}
		else {
			cnt+=boy/t + 1;
		}
		
		if(girl%t==0) {
			cnt+=girl/t;
		}
		else {
			cnt+=girl/t + 1;
		}
    	
    	System.out.println(cnt);
	}
}
