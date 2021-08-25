package com.web.model;

public class CalcModel {
	public int sum(int n1,int n2) {
		int sum = 0;
		for(int i = 1; i<=n2; i++) {
			sum+=i;
		}
		return sum;
	}
}
