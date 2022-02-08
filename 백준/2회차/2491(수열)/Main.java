import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //수열길이 N
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int before = Integer.parseInt(st.nextToken());
		int count = 0;
		int samecnt = 0;
		int maxcnt = 0;
		//이전의 상태를 -1 초기상태 0 증가 1 증가하면서같음 2 감소 3 감소하면서같음 4 그냥 같음
		//6개의 상태로 나누어서 작업
		int status = -1; // -1 X 0 inc 1 incsame 2 dec 3 decsame 4 == same
		for (int i = 1 ; i < N; i++) {
			int current = Integer.parseInt(st.nextToken());
			if (before < current) {
				switch(status) {
				case 0:
					count++;
					break;
				case 1:
					count = count + samecnt + 1;
					samecnt = 0;
					break;
				case 2:
					//현재 카운트 저장
					if (maxcnt < count+1) maxcnt = count+1;
					//
					count = 1; //카운트 초기화
					break;
				case 3:
					//현재 카운트 저장
					if (maxcnt < count+1+samecnt) maxcnt = count+1+samecnt;
					count = samecnt + 1; //카운트 초기화 
					samecnt = 0;
					break;
				case 4:
					count = count + samecnt + 1;
					samecnt = 0;
					break;
				default:
					count++;
					break;
				}
				status = 0;
			}else if (before > current) {
				switch(status) {
				case 0:
					if (maxcnt < count+1) maxcnt = count+1;
					count = 1; //카운트 초기화
					break;
				case 1:
					if (maxcnt < count+1+samecnt) maxcnt = count+1+samecnt;
					count = samecnt + 1; //카운트 초기화 
					samecnt = 0;
					break;
				case 2:
					count++;
					break;
				case 3:
					count = count + samecnt + 1;
					samecnt = 0;
					break;
				case 4:
					count = count + samecnt + 1;
					samecnt = 0;
					break;
				default:
					count++;
					break;
				}
				status = 2;
			}else {
				samecnt++;
				switch(status) {
				case 0:
					status = 1;
					break;
				case 1:
					break;
				case 2:
					status= 3;
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					status = 4;
					break;
				}
			}
			before = current;
		}
		//마지막까지 세어진 카운트 비교
		int lastcount = count + samecnt + 1;
		if (maxcnt < lastcount) maxcnt = lastcount;
		System.out.println(maxcnt);
	}
}
