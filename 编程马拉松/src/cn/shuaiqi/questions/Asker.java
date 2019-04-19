package cn.shuaiqi.questions;

import java.util.Scanner;

/*
 * ÕÊº“
 */
public class Asker {
	String question;
	//Ã·Œ 
	String Ask(){
		Scanner inQ = new Scanner(System.in);
		question = inQ.nextLine();
		return question;
	}
}
