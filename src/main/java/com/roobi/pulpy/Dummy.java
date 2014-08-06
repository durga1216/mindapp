package com.roobi.pulpy;

import java.util.Arrays;

public class Dummy {
	public static void main(String[] args){
		
		String test="b=b&w=w&e=e&a=a&c=c";
		String[] tst1=test.split("&");Arrays.sort(tst1);
		int no=tst1.length;String tst3="";
		for(int i=1;i<no;i++){
			tst3=tst3+"&"+tst1[i];
		}
		String tst4=tst1[0]+tst3;
		System.out.println(tst4);
		
	}
}
