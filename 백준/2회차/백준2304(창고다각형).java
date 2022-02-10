package ps;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;


//7
//2 4
//11 4
//15 8
//4 6
//5 3
//8 10
//13 6
public class B2304 {
	
	static class idxcmp implements Comparator<Pair>{
		@Override
		public int compare(Pair p1, Pair p2) {
			if(p1.i>p2.i)return 1;
			else if(p1.i<p2.i)return -1;
			else return 0;
		}
	}
	
	static class Pair{
		int i, h;
		Pair(int i, int h){
			this.i = i;
			this.h = h;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		List<Pair> list = new ArrayList<>();
		int mosth = 0;
		int mostidx = 0;
		
		for(int i=1; i<=num; i++) {
			int idx = sc.nextInt();
			int h = sc.nextInt();
			list.add(new Pair(idx, h));
			
			if(mosth<=h) {
				mosth=h; 
				mostidx=idx;
			}
		}
		
		//System.out.println("mosti:" +mostidx);
		list.sort(new idxcmp());				//idx 순으로 정렬 
		
		
		
		Queue<Pair> Lst = new LinkedList<>();
		for(int i=0; i<list.size(); i++) {
			Lst.add(list.get(i));
			if(list.get(i).i == mostidx)break;
		}
		//System.out.println("LstSize:" + Lst.size());
		
		Queue<Pair> Rst = new LinkedList<>();
		for(int i=list.size()-1; i>=0; i--) {
			Rst.add(list.get(i));
			if(list.get(i).i == mostidx)break;
		}
		//System.out.println("RstSize:" + Rst.size());
		
		int sum = 0;
		
		Pair now = Lst.poll();
		while(!Lst.isEmpty()) {
			Pair next = Lst.poll();
			if(now.h <= next.h) {
				sum+=(next.i - now.i)*now.h;
				now = next;
			}
		}
		int leftsize = sum;
		//System.out.println("leftsize: "+leftsize);
		
		now = Rst.poll();
		while(!Rst.isEmpty()) {
			Pair next = Rst.poll();
			if(now.h <= next.h) {
				sum+=(now.i - next.i)*now.h;
				now = next;
			}
		}
		sum+=mosth;
		int rightsize = sum-leftsize;
		//System.out.println("rightsize: "+rightsize);
		System.out.println(sum);
		
	}
}
