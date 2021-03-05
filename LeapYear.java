package com.cal;

import java.util.Scanner;

/*
 * ① 서력 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고, 
 * ② 그 중에서 100으로 나누어 떨어지는 해는 평년으로 하며, 
 * ③ 다만 400으로 나누어 떨어지는 해는 다시 윤년으로 정하였다.
 */

public class LeapYear {

	public static boolean isLeapYear(int year) {
		// 1 : year % 4 == 0 && 
		// 2 : year % 100 !=0
		// ||
		// 3 : year % 400 == 0
		boolean isLeap = false;
		
		if((year % 4 == 0)&& (year % 100!=0) || (year % 400 ==0)){
			isLeap = true;
		} else {
			isLeap = false;
		}

		return isLeap;
	}

	public static void main(String[] args) {
		// 입력한 연도가 윤년이면 "윤년이 맞습니다."
		// 아니면 "윤년이 아닙니다." 출력
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("연도를 입력해주세요. : ");
		
		int year = scanner.nextInt();
		if (isLeapYear(year)) {
			System.out.println(year + "는 윤년이 맞습니다.");
		}else {
			System.out.println(year + "는 평년이 맞습니다.");
		}

	}
}


