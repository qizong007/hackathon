package cn.shuaiqi.questions;

import java.util.Scanner;

/*
 * ���
 */
public class Asker {
	String question;
	//����
	String Ask(){
		Scanner inQ = new Scanner(System.in);
		question = inQ.nextLine();
		return question;
	}
}
