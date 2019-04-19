package cn.shuaiqi.questions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Story{

	public static void main(String[] args) {
		//ѡ�����
		System.out.println("1.Ů����\n2.���ֵ�\n3.����\n4.������\n5.��ѧ");
		System.out.println("��ѡ����£�");
		//����
		Scanner input = new Scanner(System.in);
		int num =input.nextInt();
		String filePathSurface = "src/Surface/"+num+".txt";
		String filePathBottom = "src/Bottom/"+num+".txt";
		String filePathAnalysis = "src/Analysis/"+num+".txt";
		//��ʾ����
		System.out.println("����Ϊ��");
		readTxtFile(filePathSurface);
		for(int time=0;time<5;time++) {
		//����������
		System.out.println("�������������(��ʾ����Ҫ�÷񶨾������ʻ������������!)��");
		Asker player = new Asker();
		String question = player.Ask();
		//ϵͳ�ش�
		String answer = "";
		Answerer system = new Answerer();
		System.out.println("�ش��ǣ�");
		try {
			system.Answer(question, filePathAnalysis,num,answer);
		} catch (FileNotFoundException e) {
			System.err.println("���²�����");
		} catch (Exception e) {
			e.printStackTrace();		
		}
		if(time>=0 && time<=3)
			System.out.println("����"+(4-time)+"�λ���");
		if(time==3)
			System.err.println("���ͣ�����һ�λ��ᣡ����Ϳ측��ˮ��...");
		}
		//��ʾ����
		System.out.println("����Ϊ��");
		readTxtFile(filePathBottom);
	}
	
	
	//����
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
			System.err.println("���²����ڣ�");
			}
		}catch(Exception e){
			System.err.println("��ȡ����");
		}
	}
}
