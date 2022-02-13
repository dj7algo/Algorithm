package a0213;

import java.util.*;
public class B2635 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<Integer> tmp;
		
		
		for(int i=num/2; i<=num; i++) {
			
			tmp = new ArrayList<>();
			int first = num;
			int second = i;
			tmp.add(first); tmp.add(second);
			
			while(true) {
				int last = first - second;
				if(last<0)break;
				else {
					tmp.add(last);
					first = second;
					second = last;
				}
			}
			
			if(result.size() < tmp.size()) {
				result.removeAll(result);
				for(int k=0; k<tmp.size(); k++) {
					result.add(tmp.get(k));
				}
			}
		}
		System.out.println(result.size());
		for(int k=0; k<result.size(); k++) {
			System.out.print(result.get(k)+" ");
		}
		
	}
}
