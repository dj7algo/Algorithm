package a0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/*
 몇초후의 상태를 나타내는것이 아니라 최종 결과에서 교착상태의 
 개수를 나타내는 것이니까 굳이 이동시킬 필요없을듯?
 x축 방향으로 이동하면서 교착상태 발생할 개수만 파악하면될듯
 */
public class Magnetic {

	static int[][] arr;
	static int size;
	
	static int find2idx(int nowidx, int j) {
		
		for(int i=nowidx; i<size; i++) {
			if(arr[i][j]==2)return i;
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			size = Integer.parseInt(br.readLine());
			
			arr = new int[size][size];
			for(int i=0; i<size; i++) {
				StringTokenizer ST = new StringTokenizer(br.readLine());
				for(int j=0; j<size; j++) {
					arr[i][j] = Integer.parseInt(ST.nextToken());
				}
			}
			
			int allblock = 0;
			for(int j=0; j<size; j++) {
				int nowblock = 0;			//현재 열에 교착상태 개수 
				int nowidx = 0;				//지금 탐색중인 idx
				
				while(nowidx<size) {
					//System.out.println(nowidx);
					if(arr[nowidx][j]==2) {
						nowidx++;
						continue;
					}
					else if(arr[nowidx][j]==1) {
						int next2idx = find2idx(nowidx+1, j);
						if(next2idx == -1)break;
						else {
							nowblock++;
							nowidx = next2idx+1;
						}
					}else nowidx++;

				}
				allblock+=nowblock;
				//System.out.println(nowblock);
			}
			System.out.println("#"+tc+" "+allblock);
		}
	}

}
