package com.coffee01;

import java.util.Scanner;

public class CoffeeMachine {

	public void inputMoney() {
		System.out.println("돈을 넣어 주세요\n(1잔당 300원)");
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();

		if (money >= 300) {
			coffeeMake(money);
		} else {
			System.out.println("금액이 부족합니다.");
		}
	}

	public void coffeeMake(int money) {
		int coffee = money / 300;
		int change = money % 300;
		System.out.println("커피 " + coffee + "잔 나왔습니다.");
		System.out.println((change > 0) ? "잔돈은 " + change + "원 입니다." : "");
	}

	
}
