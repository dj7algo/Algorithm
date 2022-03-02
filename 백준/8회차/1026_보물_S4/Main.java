import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer>b = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			b.add(Integer.parseInt(st.nextToken()));
		}
		
		
		
		Collections.sort(b);
		Collections.reverse(b);
		
		Collections.sort(a);
		
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			int numA = a.get(i);
			int numB = b.get(i);
			
			sum += (numA * numB);
		}
		System.out.println(sum);
	}
}
