package com.three;

import java.util.Scanner;

public class forThree {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int a =sc.nextInt();
		int sum = 0;
		
		for(int i = a; i>0 ; i--) {
			sum += i;
		}
		System.out.println(sum);
	}
}
