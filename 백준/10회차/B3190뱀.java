package a0306;
import java.util.*;
import java.io.*;

/*
 
 사과 먹었을때 -> 머리쪽만 늘어나고 꼬리는 그대로 
 사과 못먹었을때 -> 머리쪽 늘어나고 꼬리도 1개 줄음 
 
 뱀이 움직임을 어떻게 표현?
 ->list로 표현 하면 될듯?
 -> 사과를 먹었을때 -> 마지막 index에 접근해서 새로운 좌표 추가 
 -> 사과 못먹었을때 -> 마지막 index에 새로운 좌표 추가 + 처음 index remove
 */
public class B3190뱀 {

	static int size;
	static List<int[]> list;
	
	static class pair{
		int movetime;
		char dir;
		
		pair(int movetime, char dir){
			this.movetime = movetime;
			this.dir = dir;
		}
	}
	
	static int[] di = {0, 1, 0, -1};
	static int[] dj = {1, 0, -1, 0};		//우 하 좌 상 
	static int d ;
	
	static boolean check(int i, int j) {
		if(1<=i&&i<=size && 1<=j&&j<=size)return true;
		return false;
	}
	
	static boolean accident(int i, int j) {				//자신과 부딪히는지 체크
		
		for(int k=0; k<list.size(); k++) {			
			int[] now = list.get(k);
			int nowi = now[0];	int nowj = now[1];
			
			if(nowi == i && nowj == j)return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		size = sc.nextInt();
		int applenum = sc.nextInt();
		
		int[][] arr = new int[size+1][size+1];		//좌표 선언
		
		for(int i=0; i<applenum; i++) {
			int applei = sc.nextInt();
			int applej = sc.nextInt();				//사과의 좌표 입력받기
			
			arr[applei][applej] = -1;				//사과 위치를 -1로 표시 
		}
		
		int movenum = sc.nextInt();
		
		pair[] moveinfo = new pair[movenum];		//이동정보를 담을 pair형 배열 
		
		int moveidx = 0;
		
		for(int i=0; i<movenum; i++) {
			int movetime = sc.nextInt();
			char dir = sc.next().charAt(0);
			
			moveinfo[i] = new pair(movetime, dir);
		}
		
		// ------------입력 끝-----------------
		
		int firsti = 1; 
		int firstj = 1;
		
		d = 0;		//초기 방향은 "오른쪽"
		
		int time = 0;
		
		list = new ArrayList<>();		//뱀의 길이정보를 담을 리스트
		
		list.add(new int[] {1,1});
		
		while(true) {
			time++;
			int[] head = list.get(list.size()-1);
			int headi = head[0];	int headj = head[1];
			
			int ni = headi+di[d];	int nj = headj+dj[d];
			//System.out.println(ni+" "+nj);
			
			if(!check(ni, nj) || accident(ni,nj))break;
			else {
				if(arr[ni][nj]==0) {		//사과를 못먹었을때 
					list.remove(0);			//꼬리부분 한칸 삭제
				}else {
					arr[ni][nj] = 0;		//사과 먹었을때는 0으로 바꿔줌
				}
				list.add(new int[]{ni, nj});	//머리 추가는 공통 
			}
			
			if(moveidx<movenum && moveinfo[moveidx].movetime == time) {	//시간이 방향전환 시간정보와 일치할때
				if(moveinfo[moveidx].dir == 'L') {
					d--;	if(d<0)d+=4;
				}else d=(d+1)%4;
				moveidx++;
			}
			
		}
		
		System.out.println(time);
		
	}
}
