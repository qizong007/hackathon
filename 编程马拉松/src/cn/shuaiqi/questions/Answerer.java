package cn.shuaiqi.questions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/*
 * 系统
 * 回答：【是】【不是】【与此无关】
 */
public class Answerer {
	Asker asker = new Asker();
	String filePathBottom;
	int count;
	//回答
	void Answer(String question,String filePathBottom,int num,String answer) throws Exception, FileNotFoundException{
		char[] charQuestion = question.toCharArray();
		filePathBottom = "src/Analysis/"+num+".txt";
		File fileBottom = new File(filePathBottom);
		InputStreamReader reader = new InputStreamReader(
				new FileInputStream(fileBottom),"GBK");
		BufferedReader br = new BufferedReader(reader);
		answer = br.readLine();
		while((br.readLine()) != null) {
			answer = answer+br.readLine();
		}
		char[] charBottom = answer.toCharArray();
		br.close();
		//比较
		for(int i=0;i<charBottom.length;i++) {
			for(int j=0;j<charQuestion.length;j++)
				if(charBottom[i]==charQuestion[j]) {
					count++;
				}
		}
		if(count<4) {
			System.out.println("与此无关");
		}else {
			if(count>=4 && count<6)
				System.out.println("不是");
			else
				System.err.println("是");
		}
		
	}
	
	
	
}
