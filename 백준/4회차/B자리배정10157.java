package a0213;

import java.util.*;

public class B10157 {

	static int garo;
	static int sero;
	
	static boolean safe(int i, int j) {
		if(0<i&&i<=sero && 0<j&&j<=garo)return true;
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		garo = sc.nextInt();
		sero = sc.nextInt();
		int num = sc.nextInt();
		
		int[][] arr = new int[sero+1][garo+1];
		
		int cnt = 1;
		
		int[] di = {-1, 1, 0, 0};								//사방탐색 배열 
		int[] dj = {0, 0, 1, -1};		
		int d = -1;												//방향 결정 변수
		
		boolean visit[][] = new boolean [sero+1][garo+1];		//방문처리 배열
		int nowi = sero+1;			
		int nowj = 1;											// 달팽이처럼 이동할 좌표변수
		int ni = 0; int nj = 0;									// 범위 확인할 다음 좌표 
		int findi = 0; int findj = 0;
		
		if(num>garo*sero)System.out.println(0);
		else {	
			outer:while(cnt<=num) {
				d++;
				d = d%4;
				ni = nowi+di[d]; nj=nowj+dj[d];
				
				while(safe(ni, nj) && !visit[ni][nj] && cnt<=num) {				//좌표 범위내부인지, 방문 안했는지 체크 
					nowi = ni; nowj = nj;							// 조건 만족하면 지금 방향으로 한칸이동 
					
					arr[nowi][nowj] = cnt;							//이동 후 숫자 입력 
					visit[nowi][nowj] = true;						//방문처리 
					if(num==cnt) {
						findi = nowi;
						findj = nowj;
						break outer;
					}
					cnt++;											//다음 숫자 +1
					ni = nowi+di[d]; nj=nowj+dj[d];					//다음 방문할 좌표 
				}
				
//				for(int i=1; i<=sero; i++) {
//					for(int j=1; j<=garo; j++) {
//						System.out.print(arr[i][j]+"\t");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			int tmp = sero+1-findi;
			System.out.println(findj+" "+tmp);
				
		}
	}
}
