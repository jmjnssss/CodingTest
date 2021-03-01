package com.fiirst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdivB {
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] str = br.readLine().split(" ");
		double a = Integer.parseInt(str[0]);
		double b = Integer.parseInt(str[1]);
		
		System.out.println(a/b);
	}

}
