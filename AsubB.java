package com.fiirst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AsubB {

	public static void main(String[] args) throws IOException {
		/*
		int a,b;
		
		Scanner sc = new Scanner(System.in);
		
		a =  sc.nextInt();
		b = sc.nextInt();
		
		System.out.println(a-b);
		*/
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		
		System.out.println(a-b);
		
	}
}
