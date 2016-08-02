package com.qjk.ssh.util;

import java.util.Random;

public final class VerifyCodeUtil {

	
	public static String randomCode(int length){
		
		if(length == 0){
			return "";
		}
		StringBuilder sb= new StringBuilder(length);
		Random r = new Random();
		for (int i = 0; i < length; i++) {

			sb.append(r.nextInt(10));
		}
		
		return sb.toString();
	}public VerifyCodeUtil() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		System.out.println(randomCode(4));
	}
}
