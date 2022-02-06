
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
			

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Node>list = new ArrayList<>();
		
		String [] t = br.readLine().split(" ");
		
		int a = Integer.parseInt(t[0]);
		int b = Integer.parseInt(t[1]);
		
		t = br.readLine().split("");
		
		for(int i=a-1; i>=0; i--) {
			list.add(new Node(t[i],true));
		}
		
		t = br.readLine().split("");
		for(int i=0; i<b; i++) {
			list.add(new Node(t[i],false));
		}
		

		int tc = Integer.parseInt(br.readLine());
		
		while(tc-->0) {
			
			for(int i=0; i<list.size()-1; i++) {
				Node tmp1 = list.get(i);
				Node tmp2 = list.get(i+1);
					if(!tmp2.team &&tmp1.team != tmp2.team) {
						list.set(i, tmp2);
						list.set(i+1, tmp1);
						i++;
					}
			}
	}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i).name);
		}
		System.out.println(sb);
	}
 }
class Node{
	String name;
	boolean team;
	
	Node(String name, boolean team){
		this.name = name;
		this.team = team;
	}
}