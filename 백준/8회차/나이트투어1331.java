package a0301;
/*
 map이용하면될듯?
 좌표로 바꿀필요없이
 map<char, ArrayList<Integer>> 이용해서 구현
 */

import java.util.*;
import java.io.*;
public class 나이트투어1331 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Character, ArrayList<Integer>> m = new HashMap<>();
		m.put('A', new ArrayList<>());
		m.put('B', new ArrayList<>());
		m.put('C', new ArrayList<>());
		m.put('D', new ArrayList<>());
		m.put('E', new ArrayList<>());
		m.put('F', new ArrayList<>());		//문자별로 ArrayList생성
		
		int flag = 0;
		int prei=0; int prej=0;
		int nowi=0; int nowj=0;
		int firsti = 0; int firstj = 0;
		
		
		for(int i=0; i<36; i++) {
			String tmp = br.readLine();
			
			prei = nowi; prej = nowj;	//직전 좌표
			
			char ch = tmp.charAt(0);
			int num = tmp.charAt(1)-'0';
			
			nowi = ch-'0'+1; nowj = num;
			
			if(m.get(ch).contains(num))flag = 1; 	//이미 해당 문자에 그 원소가 입력된경우 입력은 다받아야되니까 flag처리					
			else {
				m.get(ch).add(num);
				int dis = Math.abs(nowi-prei)+Math.abs(nowj-prej);
				
				if(i==0) {
					firsti = nowi; 
					firstj = nowj;
					continue;
				}
				else if(i==35) {
					int firstcheck = Math.abs(firsti-nowi)+Math.abs(firstj-nowj);
	 				if(firstcheck==3 && nowi!=firsti && nowj!=firstj)continue;
	 				else flag = 1;
				}
				
				if(dis==3 && nowi!=prei && nowj!=prej)continue;
				else flag = 1;
			}
		}
		
		
		
		if(flag==1)System.out.println("Invalid");
		else System.out.println("Valid");
	}

}
