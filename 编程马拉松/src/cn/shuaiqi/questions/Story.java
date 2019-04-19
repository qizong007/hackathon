package cn.shuaiqi.questions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Story{

	public static void main(String[] args) {
		//选择故事
		System.out.println("1.女明星\n2.三兄弟\n3.妻子\n4.汉堡店\n5.放学");
		System.out.println("请选择故事：");
		//输入
		Scanner input = new Scanner(System.in);
		int num =input.nextInt();
		String filePathSurface = "src/Surface/"+num+".txt";
		String filePathBottom = "src/Bottom/"+num+".txt";
		String filePathAnalysis = "src/Analysis/"+num+".txt";
		//显示汤面
		System.out.println("汤面为：");
		readTxtFile(filePathSurface);
		for(int time=0;time<5;time++) {
		//玩家提出问题
		System.out.println("请输入你的问题(提示：不要用否定句来提问或无意义的问题!)：");
		Asker player = new Asker();
		String question = player.Ask();
		//系统回答
		String answer = "";
		Answerer system = new Answerer();
		System.out.println("回答是：");
		try {
			system.Answer(question, filePathAnalysis,num,answer);
		} catch (FileNotFoundException e) {
			System.err.println("故事不存在");
		} catch (Exception e) {
			e.printStackTrace();		
		}
		if(time>=0 && time<=3)
			System.out.println("还有"+(4-time)+"次机会");
		if(time==3)
			System.err.println("加油！还有一次机会！真相就快浮出水面...");
		}
		//显示汤底
		System.out.println("汤底为：");
		readTxtFile(filePathBottom);
	}
	
	
	//故事
	public static void readTxtFile(String filePath) {
		try {
		String encoding = "GBK";
		File file = new File(filePath);
		if(file.isFile()&&file.exists()) {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
			BufferedReader br = new BufferedReader(read);
			String lineTxt = null;
			while((lineTxt = br.readLine())!=null) {
				System.out.println(lineTxt);
			}
			read.close();
		}else {
			System.err.println("故事不存在！");
			}
		}catch(Exception e){
			System.err.println("读取错误！");
		}
	}
}
