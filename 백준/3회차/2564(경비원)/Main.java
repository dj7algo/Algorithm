import java.io.*;
import java.util.*;

public class Main {
	static int[] origin = new int[2];
	//북남서동 1234
	static int w;
	static int h;
	static int calc(int[] y ) {
		if (origin[0] == 1) { //base가 북쪽
			switch(y[0]) {
			case 1:
				return Math.abs(y[1]-origin[1]);
			case 2:
				int len = y[1] + origin[1] + h;
				if (len < (w+h)) {
					return len;
				}else {
					return (2*(w+h)-len);
				}
			case 3:
				return origin[1] + y[1];
			default:
				return (w-origin[1]) + y[1];
			}
		}else if(origin[0] == 2) { //base가 남쪽
			switch(y[0]) {
			case 1:
				int len = y[1] + origin[1] + h;
				if (len < ( w+h) ) {
					return len;
				}else {
					return ( 2*(w+h)-len);
				}
			case 2:
				return Math.abs(y[1]-origin[1]);
			case 3:
				return origin[1] + (h-y[1]);
			default:
				return (w-origin[1]) + (h-y[1]);
			}
		}else if (origin[0] == 3) { //base가 서쪽
			switch(y[0]) {
			case 1:
				return origin[1] + y[1];
			case 2:
				return origin[1] + (h-y[1]);
			case 3:
				return Math.abs(y[1]-origin[1]);
			default:
				int len = y[1] + origin[1] + w;
				if (len < ( (w+h)) ) {
					return len;
				}else {
					return ( 2*(w+h)-len);
				}
			}
		}else { //base가 동쪽
			switch(y[0]) {
			case 1:
				return origin[1] + (w-y[1]);
			case 2:
				return (h-origin[1]) + (w-y[1]); 
			case 3:
				int len = y[1] + origin[1] + w;
				if (len < ( (w+h)) ) {
					return len;
				}else {
					return ( 2*(w+h)-len);
				}
			default:
				return Math.abs(y[1]-origin[1]);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		//하나하나 다비교하는거로 짬
//		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		int numS = Integer.parseInt(br.readLine());
		int[][] l = new int[numS][2];
		for(int i = 0; i < numS; i++) {
			st = new StringTokenizer(br.readLine());
			l[i][0] = Integer.parseInt(st.nextToken());
			l[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		origin[0] = Integer.parseInt(st.nextToken());
		origin[1] = Integer.parseInt(st.nextToken());
		int res = 0;
		for(int i = 0 ; i < numS; i++) {
			res += calc(l[i]);
		}
		System.out.println(res);
	}
}
