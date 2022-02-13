package a0213;

import java.util.*;


// 모든 사각형의 넓이를 들어오는 좌표를 기준으로 계산하여 list에 넣고 정렬한다

public class B2628 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int garo = sc.nextInt();
		int sero = sc.nextInt();
		int linenum = sc.nextInt();
		
		ArrayList<Integer> garolist = new ArrayList<>();
		ArrayList<Integer> serolist = new ArrayList<>();
		garolist.add(0); serolist.add(0);
		
		for(int i=0; i<linenum; i++) {					//가로, 세로 구분하여 입력한다.
			int dir = sc.nextInt();
			if(dir==0)garolist.add(sc.nextInt());
			else serolist.add(sc.nextInt());
		}
		garolist.add(sero); serolist.add(garo);
		
		Collections.sort(garolist);	
		Collections.sort(serolist); 					//인덱스 기준으로 정렬 
		
		ArrayList<Integer> box = new ArrayList<>();		//사각형 넓이 저장할 리스트
		
		for(int i=1; i<garolist.size(); i++) {
			int nowsero = garolist.get(i)-garolist.get(i-1);
		
			for(int j=1; j<serolist.size(); j++) {
				int nowgaro = serolist.get(j)-serolist.get(j-1);
				
				box.add(nowsero * nowgaro);
			}
		}
		Collections.sort(box);
		System.out.println(box.get(box.size()-1));
		
	}
}
