import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int n = Integer.parseInt(br.readLine());
    	ArrayList<Integer>list = new ArrayList<>();

    	
    	String [] t = br.readLine().split(" ");
    	
    	for(int i=0; i<n; i++) {
    		
    		if(i==0) {
    			list.add(1);
    			continue;
    		}
    		
    		int order = Integer.parseInt(t[i]);
    		
    		list.add(i-order , i+1);
    		
    	}
    	for(int i=0; i<n; i++) {
    		System.out.print(list.get(i)+" ");
    	}
    	
    }
}
