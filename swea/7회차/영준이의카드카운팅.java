package a0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class 영준이의카드카운팅 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			String st = br.readLine();
			
			Map<Character, ArrayList<Integer>> map = new HashMap<>();
			map.put('S', new ArrayList<>());
			map.put('D', new ArrayList<>());
			map.put('H', new ArrayList<>());
			map.put('C', new ArrayList<>());
			int flag  = 0;
			
			for(int idx=0; idx<st.length(); idx+=3) {
				char ch = st.charAt(idx);
				int num = Integer.parseInt(st.substring(idx+1, idx+3));
				
				if(map.get(ch).contains(num)) {
					System.out.println("#"+tc +" ERROR");
					flag = 1;
					break;
				}
				else {
					map.get(ch).add(num);
				}
			}
			
			if(flag==0) {
				System.out.print("#"+tc+" ");
				System.out.print(13-map.get('S').size()+" ");
				System.out.print(13-map.get('D').size()+" ");
				System.out.print(13-map.get('H').size()+" ");
				System.out.print(13-map.get('C').size()+" ");
				System.out.println();
			}
			
		}
	}

}
