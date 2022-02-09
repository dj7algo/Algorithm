package A0209;
import java.util.*;
/*
총 4가지 경우가 있으며 각각 방향으로 들어오는 숫자의 조합의 갯수가 다 다르다 
-> 이것을 기준으로 구분한다. 

큰 사각형 - 작은사각형으로 해당 넓이를 구한다.
작은 사각형의 가로, 세로는 방향으로 들어오는 숫자의 양옆에 들어오는 숫자로 구별한다.

*/
public class B2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		class Pair{
			int dir;
			int len;
			Pair(int dir, int len) {
				this.dir = dir;
				this.len = len;
			}
		}
		
		int num = sc.nextInt();
		
		int[] mem = new int[7];
		Pair[] pair = new Pair[7];
		
		for(int i=1; i<=6; i++) {
			int tmpdir = sc.nextInt();
			int tmplen = sc.nextInt();
			mem[tmpdir]++;								//모양체크 
			pair[i] = new Pair(tmpdir, tmplen);			
		}
		

		
		int biggaro = 0;
		int bigsero = 0;
		int mingaro = 0;
		int minsero = 0;
		
		if(mem[1]==2&&mem[2]==1&&mem[3]==1&&mem[4]==2) {
			//1번경우
			for(int i=1; i<=6; i++) {
				int leftidx = i-1;
				int rightidx = i+1;
				if(leftidx==0)leftidx=6;
				if(rightidx==7)rightidx=1;
				
				if(pair[i].dir==2)biggaro=pair[i].len;
				else if(pair[i].dir==3)bigsero=pair[i].len;
				else if(pair[i].dir==4) {
					if(pair[leftidx].dir==1 && pair[rightidx].dir==1) {
						minsero = pair[i].len;
					}
				}else if(pair[i].dir==1) {
					if(pair[leftidx].dir==4 && pair[rightidx].dir==4) {
						mingaro = pair[i].len;
					}
				}
			}
			
		}else if(mem[1]==2&&mem[2]==1&&mem[3]==2&&mem[4]==1) {
			//2번 경우
			for(int i=1; i<=6; i++) {
				int leftidx = i-1;
				int rightidx = i+1;
				if(leftidx==0)leftidx=6;
				if(rightidx==7)rightidx=1;
				
				if(pair[i].dir==2)biggaro=pair[i].len;
				else if(pair[i].dir==4)bigsero=pair[i].len;
				else if(pair[i].dir==3) {
					if(pair[leftidx].dir==1 && pair[rightidx].dir==1) {
						minsero = pair[i].len;
					}
				}else if(pair[i].dir==1) {
					if(pair[leftidx].dir==3 && pair[rightidx].dir==3) {
						mingaro = pair[i].len;
					}
				}
			}
			
		}else if(mem[1]==1&&mem[2]==2&&mem[3]==2&&mem[4]==1) {
			//3번경우
			for(int i=1; i<=6; i++) {
				int leftidx = i-1;
				int rightidx = i+1;
				if(leftidx==0)leftidx=6;
				if(rightidx==7)rightidx=1;
				
				if(pair[i].dir==1)biggaro=pair[i].len;
				else if(pair[i].dir==4)bigsero=pair[i].len;
				else if(pair[i].dir==3) {
					if(pair[leftidx].dir==2 && pair[rightidx].dir==2) {
						minsero = pair[i].len;
					}
				}else if(pair[i].dir==2) {
					if(pair[leftidx].dir==3 && pair[rightidx].dir==3) {
						mingaro = pair[i].len;
					}
				}
			}
			
		}else if(mem[1]==1&&mem[2]==2&&mem[3]==1&&mem[4]==2) {
			//4번경우
			for(int i=1; i<=6; i++) {
				int leftidx = i-1;
				int rightidx = i+1;
				if(leftidx==0)leftidx=6;
				if(rightidx==7)rightidx=1;
				
				if(pair[i].dir==1)biggaro=pair[i].len;
				else if(pair[i].dir==3)bigsero=pair[i].len;
				else if(pair[i].dir==4) {
					if(pair[leftidx].dir==2 && pair[rightidx].dir==2) {
						minsero = pair[i].len;
					}
				}else if(pair[i].dir==2) {
					if(pair[leftidx].dir==4 && pair[rightidx].dir==4) {
						mingaro = pair[i].len;
					}
				}
			}
		}
		
		int result = biggaro*bigsero - mingaro*minsero;
		System.out.println(result*num);
	}
}
