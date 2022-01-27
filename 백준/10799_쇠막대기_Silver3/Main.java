import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 0;
		
		String t = br.readLine();
		Stack<Character>stack = new Stack<>();
		int close_cnt = 0;	// ) 갯수
		int last_idx = 0;
		
		
		char last_ch = t.charAt(0);
		stack.add('(');
		for(int i=1; i<t.length(); i++) {
			char ch = t.charAt(i);
			
			if(ch=='(') stack.add('(');
			if(ch==')') {
				if(last_ch =='(') {
					stack.pop();
					ans+=stack.size();
					for(int j=last_idx+1; j<i; j++) {
						if(t.charAt(j) ==')') {
							ans++;
						}
					}

					last_idx = i;
				}
				else {
					stack.pop();
				}
			}
			last_ch = t.charAt(i);
		}
		
		for(int i=last_idx+1; i<t.length(); i++) {
			if(t.charAt(i) ==')') ans++;
		}
		
		System.out.println(ans);
	}
}
